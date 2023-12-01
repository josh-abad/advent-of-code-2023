package org.example.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BasicParser {

    /**
     * Turns the input file into an array of strings, one string per line.
     *
     * @param path the path to the input file
     * @return an array of strings
     */
    public String[] readInput(String path) {
        StringBuilder result = new StringBuilder();
        InputStream inputStream = AbstractParser.class.getResourceAsStream(path);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + path);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            while (reader.ready()) {
                result.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString().split("\n");
    }
}
