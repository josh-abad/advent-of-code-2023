package org.example.day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.example.common.AbstractParser;

public class CardParser extends AbstractParser<Card> {
    @Override
    public Card parseLine(String line) {
        return new Card(getId(line), getWinningNumbers(line), getPlayerNumbers(line));
    }

    private static int getId(String line) {
        return Integer.parseInt(line.split(":")[0].split("\\s+")[1]);
    }

    private static List<Integer> getWinningNumbers(String line) {
        return Arrays.stream(line.split(": ")[1].split(" \\| ")[0].trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static List<Integer> getPlayerNumbers(String line) {
        return Arrays.stream(line.split(": ")[1].split(" \\| ")[1].trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
