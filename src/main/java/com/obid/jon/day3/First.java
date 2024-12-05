package com.obid.jon.day3;

import com.obid.jon.Reader;

import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> lines = Reader.readLines(3);
        int res = 0;

        for (int j = 0; j < lines.size(); j++) {
            String line = lines.get(j);
            for (int i = 0; i < line.length(); i++) {
                String line2 = line.substring(i);
                if (line2.startsWith("mul")) {
                    int mulIn = line2.indexOf("mul");
                    String substring = line2.substring(mulIn + 3);
                    boolean matches = substring.matches("\\(\\d{1,3},\\d{1,3}\\).*");
                    if (matches) {
                        String qavs = substring.substring(0, substring.indexOf(")") + 1);
                        qavs = qavs.substring(1, qavs.length() - 1);
                        String[] split = qavs.split(",");
                        int i2 = Integer.parseInt(split[0]);
                        int i1 = Integer.parseInt(split[1]);
                        res += i1 * i2;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
