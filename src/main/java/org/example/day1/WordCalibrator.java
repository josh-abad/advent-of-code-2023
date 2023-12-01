package org.example.day1;

import java.util.HashMap;
import java.util.Map;

public class WordCalibrator implements Calibrator {

    @Override
    public int getCalibrationValue(String line) {
        return Integer.parseInt(firstDigitFrom(line) + lastDigitFrom(line));
    }

    private String firstDigitFrom(String line) {
        int lowestIndex = Integer.MAX_VALUE;
        WordDigit result = null;
        for (var wd : WordDigit.values()) {
            final int i = line.indexOf(wd.toString());
            if (i > -1 && i < lowestIndex) {
                result = wd;
                lowestIndex = i;
            }

            final int j = line.indexOf(wd.value());
            if (j > -1 && j < lowestIndex) {
                result = wd;
                lowestIndex = j;
            }
        }
        return result != null ? result.value : "";
    }

    private String lastDigitFrom(String line) {
        int highestIndex = Integer.MIN_VALUE;
        WordDigit result = null;
        for (var wd : WordDigit.values()) {
            final int i = line.lastIndexOf(wd.toString());
            if (i > -1 && i > highestIndex) {
                result = wd;
                highestIndex = i;
            }

            final int j = line.lastIndexOf(wd.value());
            if (j > -1 && j > highestIndex) {
                result = wd;
                highestIndex = j;
            }
        }
        return result != null ? result.value : "";
    }

    enum WordDigit {
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9");

        private final String value;

        WordDigit(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }
}
