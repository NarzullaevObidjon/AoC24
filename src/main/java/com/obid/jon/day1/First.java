package com.obid.jon.day1;

import com.obid.jon.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> lines = Reader.readLines(1);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (String line : lines) {
            int num1 = Integer.parseInt(line.substring(0, 5));
            int num2 = Integer.parseInt(line.substring(8, 13));
            list1.add(num1);
            list2.add(num2);
        }
        Collections.sort(list1);
        Collections.sort(list2);

        int sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum+=Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(sum);
    }
}
