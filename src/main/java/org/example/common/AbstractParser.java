package org.example.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser<T> implements Parser<T> {

    private final BasicParser basicParser = new BasicParser();

    @Override
    public List<T> parseToList(String path) {
        final List<T> result = new ArrayList<>();
        for (String line : basicParser.readInput(path)) {
            result.add(parseLine(line));
        }
        return result;
    }
}
