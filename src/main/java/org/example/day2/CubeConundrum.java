package org.example.day2;

import java.util.List;
import java.util.Map;

import org.example.common.Parser;

public class CubeConundrum {

    public static void main(String[] args) {
        final CubeConundrum cubeConundrum = new CubeConundrum();
        final Parser<Game> gameParser = new GameParser();
        final List<Game> games = gameParser.parseToList("/day2/input.txt");
        System.out.println(cubeConundrum.sumOfPower(games));
    }

    public int sumOfPower(List<Game> games) {
        int sum = 0;
        for (var game : games) {
            sum += game.calculatePower();
        }
        return sum;
    }

    public int calculate(List<Game> games) {
        final Map<Cube, Integer> min = Map.of(Cube.RED, 12, Cube.GREEN, 13, Cube.BLUE, 14);
        int sum = 0;
        for (var game : games) {
            if (game.isWithin(min)) {
                sum += game.id();
            }
        }

        return sum;
    }
}
