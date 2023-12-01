package org.example.day1;

public class DigitCalibrator implements Calibrator {

    @Override
    public int getCalibrationValue(String line) {
        return Integer.parseInt(firstDigitFrom(line) + lastDigitFrom(line));
    }

    private String firstDigitFrom(String line) {
        for (int i = 0, len = line.length(); i < len; i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                return String.valueOf(c);
            }
        }
        return "";
    }

    private String lastDigitFrom(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                return String.valueOf(c);
            }
        }
        return "";
    }
}
