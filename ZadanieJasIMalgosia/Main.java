package com.sda.jasimalgosia;

public class Main {

    public static void main(String[] args) {
        Jas jas = new Jas();
        Malgosia malgosia = new Malgosia();

        Thread watekJasia = new Thread(jas);
        Thread watekMalgosi = new Thread(malgosia);

        watekJasia.start();
        watekMalgosi.start();

        try {
            watekMalgosi.join();
            watekJasia.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Koniec dnia");
    }
}
