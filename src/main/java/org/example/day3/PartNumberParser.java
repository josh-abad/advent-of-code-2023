package org.example.day3;

import java.util.ArrayList;
import java.util.List;

import org.example.common.BasicParser;
import org.example.common.Parser;
import org.example.common.Point;

public class PartNumberParser implements Parser<PartNumber> {

    private final BasicParser basicParser = new BasicParser();

    @Override
    public List<PartNumber> parseToList(String path) {
        final List<PartNumber> result = new ArrayList<>();

        final String[] lines = basicParser.readInput(path);
        char previousChar = '\0';
        StringBuilder valStr = new StringBuilder();
        PartNumber partNumber = null;
        for (int y = 0; y < lines.length; y++) {
            final String line = lines[y];
            for (int x = 0, len = line.length(); x < len; x++) {
                char c = line.charAt(x);
                if (Character.isDigit(c) && !Character.isDigit(previousChar)) {
                    valStr.append(c);
                    partNumber = new PartNumber(0, new Point(x, y), null);
                } else if (Character.isDigit(c) && Character.isDigit(previousChar)) {
                    valStr.append(c);
                } else if (partNumber != null && !valStr.isEmpty()) {
                    partNumber = partNumber.withValue(Integer.parseInt(valStr.toString())).withEnd(new Point(x - 1, y));
                    result.add(partNumber);
                    partNumber = null;
                    valStr = new StringBuilder();
                }

                if (x == len - 1 && partNumber != null && !valStr.isEmpty()) {
                    partNumber = partNumber.withValue(Integer.parseInt(valStr.toString())).withEnd(new Point(x - 1, y));
                    result.add(partNumber);
                }

                previousChar = c;
            }
        }

        return result;
    }

    @Override
    public PartNumber parseLine(String line) {
        throw new UnsupportedOperationException("Use parseToList");
    }
}
