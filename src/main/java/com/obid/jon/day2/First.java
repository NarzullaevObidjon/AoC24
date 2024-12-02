package com.obid.jon.day2;

import com.obid.jon.Reader;

import java.util.Arrays;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> lines = Reader.readLines(2, 1);
        int count = 0;
        for (String line : lines) {
            Integer[] numbers = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList().toArray(new Integer[0]);
            boolean inc = numbers[1] > numbers[0];
            int prev = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                Integer number = numbers[i];
                if (inc && (number <= prev || number - prev > 3)) {
                    break;
                } else if (!inc && (prev <= number || prev - number > 3)) {
                    break;
                }
                prev = number;
                if (numbers.length - 1 == i) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
