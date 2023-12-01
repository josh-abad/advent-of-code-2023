package org.example.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.example.common.BasicParser;
import org.junit.jupiter.api.Test;

class TrebuchetTest {

    @Test
    void Calculate_sum_of_all_of_the_calibration_values_with_digits() {
        final Trebuchet trebuchet = new Trebuchet(new DigitCalibrator());

        final BasicParser basicParser = new BasicParser();
        final String[] input = basicParser.readInput("/day1/input.txt");

        assertEquals(142, trebuchet.calculateCalibrationValues(input));
    }

    @Test
    void Calculate_sum_of_all_of_the_calibration_values_with_worded_numbers() {
        final Calibrator wordCalibrator = new WordCalibrator();
        final Trebuchet trebuchet = new Trebuchet(wordCalibrator);

        final BasicParser basicParser = new BasicParser();
        final String[] input = basicParser.readInput("/day1/input2.txt");

        assertEquals(281, trebuchet.calculateCalibrationValues(input));
    }
}
