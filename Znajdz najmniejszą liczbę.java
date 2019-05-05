package com.sda.generyki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(5);
        ints.add(7);
        ints.add(3);
        ints.add(1);

        System.out.println(findMinimum6(ints));
    }

    public static <T extends Number & Comparable<T>> T findMinimum6(List<T> list) {
        T currentMin = list.get(0);
        for (T value : list) {
            if (value.compareTo(currentMin) < 0) {
                currentMin = value;
            }
        }
        return currentMin;
    }

    public static <T extends Comparable<T>> T findMinimum7(List<T> list) {
        return Collections.min(list);
    }

    public static Integer findMinimum(List<Integer> list) {
        Integer currentMin = list.get(0);
        for (Integer value : list) {
            if (value < currentMin) {
                currentMin = value;
            }
        }
        return currentMin;
    }

    public static Integer findMinimum2(List<Integer> list) {
        List<Integer> listCopy = new ArrayList<>(list);
        Collections.sort(listCopy);
        return listCopy.get(0);
    }

    public static Integer findMinimum3(List<Integer> list) {
        return list.stream().min(Comparator.naturalOrder()).get();
    }

    public static Integer findMinimum4(List<Integer> list) {
        return Collections.min(list);
    }

    public static Integer findMinimum5(List<Integer> list) {
        return list.stream().sorted().findFirst().get();
    }

}
