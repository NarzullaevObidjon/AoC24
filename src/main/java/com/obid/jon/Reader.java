package com.obid.jon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Reader {
    private static final String PATH = "C:/AoC/AoC24/src/main/resources/%d/input.txt";

    public static List<String> readLines(int day) {
        Path path = Path.of(PATH.formatted(day));
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
