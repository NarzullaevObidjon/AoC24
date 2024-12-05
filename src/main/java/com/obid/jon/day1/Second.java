package com.obid.jon.day1;

import com.obid.jon.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Second {
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
        int res = 0;
        for (Integer i : list1) {
            int count = 0;
            for (Integer j : list2) {
                if(Objects.equals(i, j)) {
                    count++;
                }
            }
            res += count*i;
        }
        System.out.println(res);
    }
}
