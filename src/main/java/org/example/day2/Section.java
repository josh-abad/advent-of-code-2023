package org.example.day2;

import java.util.EnumMap;
import java.util.Map;

public record Section(Map<Cube, Integer> countForCube) {

    public static Section valueOf(String s) {
        final String[] split = s.split(", ");
        final Map<Cube, Integer> countForCube = new EnumMap<>(Cube.class);
        for (String strCube : split) {
            final String[] split1 = strCube.split(" ");
            final Cube cube = Cube.valueOf(split1[1].toUpperCase());
            final int count = Integer.parseInt(split1[0]);
            countForCube.put(cube, count);
        }
        return new Section(countForCube);
    }

    public boolean isWithin(Map<Cube, Integer> min) {
        for (Map.Entry<Cube, Integer> entry : min.entrySet()) {
            final int count = countForCube.getOrDefault(entry.getKey(), 0);
            if (count > entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
