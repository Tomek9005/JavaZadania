package com.sda.streamy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        1) Wszystkie nazwiska o długości co najwyżej 4 znaków, zapisane wielkimi literami

        DataCollections.getSurnames().stream()
                .filter(nazwisko -> nazwisko.length() <= 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

//        2) Wszystkie nazwiska zaczynające się na literę 'B'

        DataCollections.getSurnames().stream()
                .filter(nazwisko -> nazwisko.startsWith("B"))
                .collect(Collectors.toList());

//        3) Początkowe trzy litery wszystkich nazwisk, bez powtórzeń, z małych liter

        DataCollections.getSurnames().stream()
                .map(nazwisko -> nazwisko.substring(0,3).toLowerCase())
                .distinct();
                //.forEach(System.out::println);

//        4) 10 najdłuższych nazwisk, posortowanych malejąco według długości

        DataCollections.getSurnames()
                .stream()
                //.sorted((s1, s2) -> s2.length() - s1.length())
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(10);
//                .forEach(System.out::println);

//        5) 20 najkrótszych nazwisk, posortowanych według ostatniej litery

        DataCollections.getSurnames().stream()
                .sorted(Comparator.comparing(String::length))
                .limit(20)
                .sorted(Comparator.comparing(nazwisko -> nazwisko.charAt(nazwisko.length()-1)))
                .collect(Collectors.toList());

//        6) Odwróć kolejność liter we wszystkich nazwiskach i pozstaw jedynie te, które mają literę 'A' wsród pierwszych trzech liter (odwróconego nazwiska)

        DataCollections.getSurnames().stream()
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())
                .filter(nazwisko -> nazwisko.substring(0, 3).toLowerCase().contains("a"))
                .collect(Collectors.toList());

//        1) Ile jest liczb parzystych?

        System.out.println(DataCollections.getNumbers(10_000).stream()
                .filter(number -> number % 2 == 0)
                .count());

//        2) Ile jest liczb pięciocyfrowych?
        System.out.println(DataCollections.getNumbers(10_000).stream()
                .filter(number -> number >= 10_000 && number <= 99_999)
                .count());

        //        3) Jaka jest największa i najmniejsza liczba?
//        5) Jaka jest średnia wszystkich liczb?

        System.out.println(DataCollections.getNumbers(10_000).stream()
                .mapToInt(i -> i)
                .min());

        System.out.println(DataCollections.getNumbers(10_000).stream()
                .mapToInt(i -> i)
                .max());

        System.out.println(DataCollections.getNumbers(10_000).stream()
                .mapToInt(i -> i)
                .average());

        System.out.println(DataCollections.getNumbers(10_000).stream()
                .mapToInt(i -> i)
                .summaryStatistics());


//        6*) Jaka jest mediana wszystkich liczb?

        List<Integer> numbers = DataCollections.getNumbers(10_000);
        Collections.sort(numbers);
        double mediana = numbers.get(numbers.size() / 2) + numbers.get(numbers.size() / 2 + 1) / 2.0;

    }
}
