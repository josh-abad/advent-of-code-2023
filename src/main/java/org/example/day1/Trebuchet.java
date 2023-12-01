package org.example.day1;

import org.example.common.BasicParser;

public class Trebuchet {

    private final Calibrator calibrator;

    public Trebuchet(Calibrator calibrator) {
        this.calibrator = calibrator;
    }

    public static void main(String[] args) {
        final Calibrator calibrator = new WordCalibrator();
        final Trebuchet trebuchet = new Trebuchet(calibrator);

        final BasicParser basicParser = new BasicParser();
        final String[] input = basicParser.readInput("/day1/input.txt");

        System.out.println(trebuchet.calculateCalibrationValues(input));
    }

    public int calculateCalibrationValues(String[] input) {
        int result = 0;
        for (String s : input) {
            result += calibrator.getCalibrationValue(s);
        }
        return result;
    }
}
