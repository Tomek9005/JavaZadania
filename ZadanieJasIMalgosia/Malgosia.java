package com.sda.jasimalgosia;

public class Malgosia implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Małgosia: idę biegać");
            Thread.sleep(6000);
            System.out.println("Małgosia: skończyłąm biegać");
            System.out.println("Małgosia: biorę prysznic");
            Thread.sleep(2000);
            System.out.println("Małgosia: skonczylem prysznic");
            System.out.println("Małgosia: jem sniadanie");
            Thread.sleep(1000);
            System.out.println("Małgosia: zjadlam sniadanie");
            System.out.println("Małgosia: ubieram sie");
            Thread.sleep(1000);
            System.out.println("Małgosia: ubralam sie");
            System.out.println("Małgosia: ide na spotkanie z kolezanka");
            Thread.sleep(25000);
            System.out.println("Małgosia: wrocilam ze spotkania");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
