package com.obid.jon.day4;

import com.obid.jon.Reader;
import com.obid.jon.Utils;

import java.util.List;

public class Second {
    static int[][] A = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) {
        List<String> lines = Reader.readLines(4);
        int res = 0;
        char[][] matrix = Utils.toMatrix(lines);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'A') {
                    int[] index = findIndex(matrix, i, j, A[0]);
                    int x = 0;
                    if (index != null) {
                        if (matrix[index[0]][index[1]] == 'M') {
                            int[] index1 = findIndex(matrix, i, j, A[1]);
                            if (index1 != null) {
                                if (matrix[index1[0]][index1[1]] == 'S') {
                                    x++;
                                }
                            }
                        } else if (matrix[index[0]][index[1]] == 'S') {
                            int[] index1 = findIndex(matrix, i, j, A[1]);
                            if (index1 != null) {
                                if (matrix[index1[0]][index1[1]] == 'M') {
                                    x++;
                                }
                            }
                        }
                    }

                    int[] indexx = findIndex(matrix, i, j, A[2]);
                    if (indexx != null) {
                        if (matrix[indexx[0]][indexx[1]] == 'M') {
                            int[] index1 = findIndex(matrix, i, j, A[3]);
                            if (index1 != null) {
                                if (matrix[index1[0]][index1[1]] == 'S') {
                                    x++;
                                }
                            }
                        } else if (matrix[indexx[0]][indexx[1]] == 'S') {
                            int[] index1 = findIndex(matrix, i, j, A[3]);
                            if (index1 != null) {
                                if (matrix[index1[0]][index1[1]] == 'M') {
                                    x++;
                                }
                            }
                        }
                    }
                    if (x == 2) {
                        res++;
                    }
                }


            }
        }
        System.out.println(res);
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