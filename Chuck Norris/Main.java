package com.sda.chucknorris;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final String API_LINK = "https://api.chucknorris.io/jokes/random";
    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException {
        Set<Joke> jokesSet = new HashSet<>();
        while (jokesSet.size() < 10) {
            Joke joke = downloadJoke();
            jokesSet.add(joke);
        }
        for (Joke joke : jokesSet) {
            System.out.println(joke.getValue());
        }
    }

    private static Joke downloadJoke() throws IOException {
        URL url = new URL(API_LINK);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        InputStream is = connection.getInputStream();
        try (Scanner scanner = new Scanner(is)) {
            String line = scanner.nextLine();
            return GSON.fromJson(line, Joke.class);
        }
    }
}
