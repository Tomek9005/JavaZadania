package com.sda.calkowanie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.nanoTime();
        double sum = integrate(0.0, 15.0, 10_000_000);
        long endTime = System.nanoTime();
        System.out.println("One thread: " + sum);
        System.out.println("One thread: " + (endTime - startTime)/1_000_000.0 + " ms");

        startTime = System.nanoTime();
        sum = integrateMultiThread(0.0, 15.0, 10_000_000, 10);
        endTime = System.nanoTime();
        System.out.println("Multi threads: " + sum);
        System.out.println("Multi threads: " + (endTime - startTime)/1_000_000.0 + " ms");


//        double sum1 = integrate(0.0, 5.0, 3_333_333);
//        double sum2 = integrate(5.0, 10.0, 3_333_333);
//        double sum3 = integrate(10.0, 15.0, 3_333_333);
//
//        double sumAll = sum1 + sum2 + sum3;

    }

    private static double integrateMultiThread(double xStart, double xEnd, final int n, final int threads) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(threads);
        double chunkWidth = (xEnd - xStart) / threads;

        final double[] sum = {0.0};
        for (int i = 0; i < threads; i++) {

            final double xStartChunk = xStart + i*chunkWidth;
            final double xEndChunk = xStartChunk + chunkWidth;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    double partialInteger = integrate(xStartChunk, xEndChunk, n / threads);
                    sum[0] += partialInteger;
                }
            });

        }
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.DAYS);
        return sum[0];
    }

    private static double integrate(double xStart, double xEnd, int n) {
        //System.out.println("From " + xStart + " to " + xEnd + " integrate!");
        double sum = 0.0;
        double width = (xEnd - xStart) / n;
        for (double x = xStart; x < xEnd; x += width) {
            double h = function(x);
            double area = width * h;
            sum += area;
        }
        return sum;
    }

    private static double function(double x) {
        return (3*Math.sin(x)) - (0.2*Math.pow(x, 3)) + (3*Math.pow(x, 2));
    }
}
