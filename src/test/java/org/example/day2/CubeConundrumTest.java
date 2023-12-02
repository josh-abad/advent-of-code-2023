package org.example.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.example.common.Parser;
import org.junit.jupiter.api.Test;

class CubeConundrumTest {

    @Test
    void Should_calculate() {
        final CubeConundrum cubeConundrum = new CubeConundrum();
        final Parser<Game> gameParser = new GameParser();
        final List<Game> games = gameParser.parseToList("/day2/input.txt");
        assertEquals(8, cubeConundrum.calculate(games));
    }

    @Test
    void Should_calculate_sum_of_power() {
        final CubeConundrum cubeConundrum = new CubeConundrum();
        final Parser<Game> gameParser = new GameParser();
        final List<Game> games = gameParser.parseToList("/day2/input.txt");
        assertEquals(2286, cubeConundrum.sumOfPower(games));
    }
}
