package com.sda.jasimalgosia;

public class Jas implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Jaś: przygotowuję śniadanie");
            Thread.sleep(5000);
            System.out.println("Jaś: przygotowałem śniadanie");
            System.out.println("Jaś: biorę prysznic");
            Thread.sleep(3000);
            System.out.println("Jaś: skonczylem prysznic");
            System.out.println("Jaś: ubieram sie");
            Thread.sleep(1000);
            System.out.println("Jaś: ubralem sie");
            System.out.println("Jaś: Ide na zakupy");
            Thread.sleep(15000);
            System.out.println("Jaś: Wrocilem z zakupow");
            System.out.println("Jaś: Gram na konsoli");
            Thread.sleep(5000);
            System.out.println("Jaś: Skonczylem granie");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
