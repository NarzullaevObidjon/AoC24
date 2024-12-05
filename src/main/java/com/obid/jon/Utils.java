package com.obid.jon;

import java.util.List;

public class Utils {
    public static boolean isNumber(char ch){
        return ch >= '0' && ch <= '9';
    }

    public static int toInt(char[] chars, int start, int end){
        return Integer.parseInt(String.valueOf(chars, start, end - start));
    }

    public static char[][] toMatrix(List<String> lines) {
        char[][] matrix = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i).toCharArray();
        }
        return matrix;
    }

}