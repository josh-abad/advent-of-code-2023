package org.example.day3;

import java.util.HashSet;
import java.util.Set;

import org.example.common.Point;

public record PartNumber(int value, Point start, Point end) {

    boolean hasAdjacentSymbol(Set<Symbol> symbols) {
        for (var symbol : symbols) {
            if (isAdjacent(symbol.point())) {
                return true;
            }
        }

        return false;
    }

    boolean isAdjacent(Point point) {
        return adjacentPoints().contains(point);
    }

    PartNumber withValue(int value) {
        return new PartNumber(value, start, end);
    }

    PartNumber withEnd(Point end) {
        return new PartNumber(value, start, end);
    }

    private Set<Point> adjacentPoints() {
        final Set<Point> result = new HashSet<>();
        for (int x = start.x(); x <= end.x(); x++) {
            result.add(new Point(x - 1, start.y()));
            result.add(new Point(x - 1, start.y() - 1));
            result.add(new Point(x - 1, start.y() + 1));
            result.add(new Point(x + 1, start.y()));
            result.add(new Point(x + 1, start.y() - 1));
            result.add(new Point(x + 1, start.y() + 1));
            result.add(new Point(x, start.y() - 1));
            result.add(new Point(x, start.y() + 1));
        }

        return result;
    }
}
