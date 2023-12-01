package org.example.common;

import java.util.List;

public interface Parser<T> {

    List<T> parseToList(String path);

    T parseLine(String line);
}
