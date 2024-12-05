package com.obid.jon.day4;

import com.obid.jon.Reader;
import com.obid.jon.Utils;

import java.util.List;

public class First {
    static int[][] A = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) {
        List<String> lines = Reader.readLines(4);
        int res = 0;
        char[] charDepth = {'X', 'M', 'A', 'S'};
        char[][] matrix = Utils.toMatrix(lines);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'X') {
                    for (int k = 0; k < A.length; k++) {
                        int count = search(1, matrix, i, j, charDepth, k);
                        res += count;
                    }
                }
            }
        }
        System.out.println(res);
    }

    private static int search(int depth, char[][] matrix, int i, int j, char[] charDepth, int dir) {
        char ch = charDepth[depth];
        int count = 0;
        int[] indexes = findIndex(matrix, i, j, A[dir]);
        if (indexes != null) {
            if (depth == charDepth.length - 1) {
                if (matrix[indexes[0]][indexes[1]] == ch) {
                    count += 1;
                }
            } else if (matrix[indexes[0]][indexes[1]] == ch) {
                count += search(depth + 1, matrix, indexes[0], indexes[1], charDepth, dir);
            }
        }

        return count;
    }

    private static int[] findIndex(char[][] matrix, int i, int j, int[] ints) {
        int x = i + ints[0];
        int y = j + ints[1];
        if (x > -1 && y > -1 && x < matrix.length && y < matrix[0].length) {
            return new int[]{x, y};
        }
        return null;
    }
}
