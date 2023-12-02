package org.example.day2;

import java.util.ArrayList;
import java.util.List;

import org.example.common.AbstractParser;

public class GameParser extends AbstractParser<Game> {

    @Override
    public Game parseLine(String line) {
        return new Game(parseId(line), parseSections(line));
    }

    private int parseId(String line) {
        final String[] split = line.split(":");
        return Integer.parseInt(split[0].substring(5));
    }

    private List<Section> parseSections(String line) {
        final String strSections = line.split(": ")[1];
        final String[] split = strSections.split("; ");
        final List<Section> sections = new ArrayList<>();
        for (String strSection : split) {
            sections.add(Section.valueOf(strSection));
        }
        return sections;
    }
}
