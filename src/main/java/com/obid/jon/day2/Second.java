package com.obid.jon.day2;

import com.obid.jon.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second {
    public static void main(String[] args) {
        List<String> lines = Reader.readLines(2);
        int count = 0;
        for (String line : lines) {
            Integer[] numbers = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList().toArray(new Integer[0]);
            if (isSafe(numbers)) {
                count++;
            } else {
                int i = 0;
                for (int i1 = 0; i1 < numbers.length; i1++) {
                    List<Integer> list = new ArrayList<>(Arrays.stream(numbers).toList());
                    list.remove(i++);
                    if (isSafe(list.toArray(new Integer[0]))) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static boolean isSafe(Integer[] numbers) {
        boolean inc = numbers[1] > numbers[0];
        int prev = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            Integer number = numbers[i];
            if (inc && (number <= prev || number - prev > 3)) {
                return false;
            } else if (!inc && (prev <= number || prev - number > 3)) {
                return false;
            }
            prev = number;
        }
        return true;
    }
}
