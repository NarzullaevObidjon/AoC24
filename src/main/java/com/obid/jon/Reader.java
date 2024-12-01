package com.obid.jon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reader {
    private static final String PATH = "C:/AoC/AoC24/src/main/resources/%d/%d.txt";

    public static List<String> readLines(int day, int problem) {
        Path path = Path.of(PATH.formatted(day, problem));
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
