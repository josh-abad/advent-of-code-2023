package org.example.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.common.Parser;
import org.junit.jupiter.api.Test;

class GearRatiosTest {

    @Test
    void Sum_of_all_of_the_part_numbers_in_the_engine_schematic() {
        final GearRatios gearRatios = new GearRatios();
        final Parser<PartNumber> partNumberParser = new PartNumberParser();
        final List<PartNumber> partNumbers = partNumberParser.parseToList("/day3/input.txt");
        final Parser<Symbol> symbolParser = new SymbolParser();
        final Set<Symbol> symbols = new HashSet<>(symbolParser.parseToList("/day3/input.txt"));
        assertEquals(4361, gearRatios.calculate(partNumbers, symbols));
    }

    @Test
    void Sum_of_all_of_the_gear_ratios_in_your_engine_schematic() {
        final GearRatios gearRatios = new GearRatios();
        final Parser<PartNumber> partNumberParser = new PartNumberParser();
        final List<PartNumber> partNumbers = partNumberParser.parseToList("/day3/input.txt");
        final Parser<Symbol> symbolParser = new SymbolParser();
        final Set<Symbol> symbols = new HashSet<>(symbolParser.parseToList("/day3/input.txt"));
        assertEquals(467835, gearRatios.calculateGearRatios(partNumbers, symbols));
    }
}
