package org.example.day3;

import java.util.ArrayList;
import java.util.List;

import org.example.common.Point;

public record Symbol(char symbol, Point point) {

    int gearRatio(List<PartNumber> partNumbers) {
        if (symbol != '*') {
            return 0;
        }

        List<PartNumber> adjacentPartNumbers = new ArrayList<>();

        for (var partNumber : partNumbers) {
            if (partNumber.isAdjacent(point)) {
                adjacentPartNumbers.add(partNumber);
            }
            if (adjacentPartNumbers.size() > 2) {
                break;
            }
        }

        if (adjacentPartNumbers.size() != 2) {
            return 0;
        }

        return adjacentPartNumbers.get(0).value() * adjacentPartNumbers.get(1).value();
    }
}
