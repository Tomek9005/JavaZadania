package com.sda.liczbypierwsze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        long startTime = System.currentTimeMillis();

        File file = new File("src/main/resources/numbers.txt");
        int licznik = (int) ileLiczbPierwszychStreamMultipleThreads(file); //countPrimesMultipleThread(file);
        long endTime = System.currentTimeMillis();
        System.out.println("Znalazłem " + licznik + " liczb pierwszych w " + (endTime - startTime) + " ms");
    }

    private static int countPrimesMultipleThread(File file) throws FileNotFoundException, InterruptedException {
        Scanner scanner = new Scanner(file);
        ExecutorService threadPool = Executors.newFixedThreadPool(4);


        final AtomicInteger licznik = new AtomicInteger(0);
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    boolean czyPierwsza = isPrime(number);
                    if (czyPierwsza) {
                        licznik.incrementAndGet();
                        //System.out.println("Dotychczas znalazlem liczb pierwszych: " + licznik);
                    }
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
        return licznik.get();
    }

    private static int countPrimesSingleThread(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int licznik = 0;
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();

            boolean czyPierwsza = isPrime(number);
            if (czyPierwsza) {
                licznik++;
                //System.out.println("Dotychczas znalazlem liczb pierwszych: " + licznik);
            }
        }
        return licznik;
    }

    private static long ileLiczbPierwszychStream(File file) throws IOException {
        return Files.lines(file.toPath())
                .filter(s -> isPrime(Long.parseLong(s)))
                .count();
    }

    private static long ileLiczbPierwszychStreamMultipleThreads(File file) throws IOException {
        return Files.lines(file.toPath())
                .parallel()
                .filter(s -> isPrime(Long.parseLong(s)))
                .count();
    }

    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
