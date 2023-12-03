package org.example.day3;

import java.util.ArrayList;
import java.util.List;

import org.example.common.BasicParser;
import org.example.common.Parser;
import org.example.common.Point;

public class SymbolParser implements Parser<Symbol> {

    private final BasicParser basicParser = new BasicParser();

    @Override
    public List<Symbol> parseToList(String path) {
        final List<Symbol> result = new ArrayList<>();

        final String[] lines = basicParser.readInput(path);
        for (int y = 0; y < lines.length; y++) {
            final String line = lines[y];
            for (int x = 0, len = line.length(); x < len; x++) {
                char c = line.charAt(x);
                if (isSymbol(c)) {
                    result.add(new Symbol(c, new Point(x, y)));
                }
            }
        }

        return result;
    }

    @Override
    public Symbol parseLine(String line) {
        return null;
    }

    private static boolean isSymbol(char c) {
        return !Character.isDigit(c) && c != '.';
    }
}
