package org.example.day2;

import java.util.List;
import java.util.Map;

public record Game(int id, List<Section> sections) {
    public boolean isWithin(Map<Cube, Integer> min) {
        for (var section : sections) {
            if (!section.isWithin(min)) {
                return false;
            }
        }

        return true;
    }

    public int calculatePower() {
        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;

        for (var section : sections) {
            final var redCount = section.countForCube().getOrDefault(Cube.RED, 0);
            if (redCount > maxRed) {
                maxRed = redCount;
            }
            final var greenCount = section.countForCube().getOrDefault(Cube.GREEN, 0);
            if (greenCount > maxGreen) {
                maxGreen = greenCount;
            }
            final var blueCount = section.countForCube().getOrDefault(Cube.BLUE, 0);
            if (blueCount > maxBlue) {
                maxBlue = blueCount;
            }
        }

        return maxRed * maxGreen * maxBlue;
    }
}
