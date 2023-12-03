package org.example.day3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.common.Parser;

public class GearRatios {

    public static void main(String[] args) {
        final GearRatios gearRatios = new GearRatios();
        final Parser<PartNumber> partNumberParser = new PartNumberParser();
        final List<PartNumber> partNumbers = partNumberParser.parseToList("/day3/input.txt");
        final Parser<Symbol> symbolParser = new SymbolParser();
        final Set<Symbol> symbols = new HashSet<>(symbolParser.parseToList("/day3/input.txt"));
        System.out.println(gearRatios.calculateGearRatios(partNumbers, symbols));
    }

    public int calculate(List<PartNumber> partNumbers, Set<Symbol> symbols) {
        int sum = 0;
        for (var partNumber : partNumbers) {
            if (partNumber.hasAdjacentSymbol(symbols)) {
                sum += partNumber.value();
            }
        }

        return sum;
    }

    public int calculateGearRatios(List<PartNumber> partNumbers, Set<Symbol> symbols) {
        int sum = 0;
        for (var symbol : symbols) {
            sum += symbol.gearRatio(partNumbers);
        }

        return sum;
    }
}
