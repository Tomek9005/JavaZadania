//Napisz program, który rozpozna jezyk dokument, do rozpoznania jezyka uzyj serwisu DetectLanguage.com.

package com.sda.rozpoznawanieJezyka;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws APIError, FileNotFoundException {
        DetectLanguage.apiKey = "6e4f850361c3d2eab677d3a794206ee8";

        File folder = new File("src\\main\\resources\\artykuly");
        File[] files = folder.listFiles();
        for (File file : files) {
            String fullText = readFileContent(file);
            String language = DetectLanguage.simpleDetect(fullText);

            Locale locale = new Locale(language);
            Locale pl = new Locale("pl");

            System.out.println("Plik " + file.getName() + " jest w języku " + locale.getDisplayLanguage(pl));
        }
    }

    private static String readFileContent(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sb.append(line).append(" ");
        }
        return sb.toString();
    }
}
