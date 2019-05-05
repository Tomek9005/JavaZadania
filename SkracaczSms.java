//Napisz program, który zmiejsza treść SMSa, w celuzaoszczedzenia ilosci znakow nie pisz spacji, kazdy rozpoczynajacy sie wyraz 
//rozpoczynaj wielkąliterą. Wczytaj SMSa z konsoli w programi (System.in) i tam też wyświetl rezultat.


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String trescSms = scanner.nextLine();

        String skroconySms = skracaczSms(trescSms);
        System.out.println("Skrocony SMS: " + skroconySms);
        System.out.println("Normalnie SMS zajmuje dlugość " + kosztSMS(trescSms) + ", a skrócony " + kosztSMS(skroconySms));
    }

    private static int kosztSMS(String sms) {
        int ileZnakow = sms.length();
        System.out.println("DLugosc sms: " + ileZnakow);
        if (ileZnakow <= 160) {
            return 1;
        } else {
            return ((ileZnakow-1)/153) + 1;
        }
    }

    private static String skracaczSms(String sms) {
        String[] slowa = sms.split(" ");
        String wynik = "";
        for (String slowo : slowa) {
            if (slowo.isEmpty()) {
                continue;
            }
            char pierwszaLitera = slowo.charAt(0);
            pierwszaLitera = Character.toUpperCase(pierwszaLitera);
            String noweSlowo = pierwszaLitera + slowo.substring(1).toLowerCase();

            wynik += noweSlowo;
        }

        return wynik;
    }
}
