package org.example.day4;

import java.util.List;

public class Scratchcards {

    public static void main(String[] args) {
        final CardParser cardParser = new CardParser();
        final List<Card> cards = cardParser.parseToList("/day4/input.txt");
        final Scratchcards scratchcards = new Scratchcards();
        System.out.println(scratchcards.calculatePoints(cards));
    }

    public int calculatePoints(List<Card> cards) {
        int sum = 0;
        for (var card : cards) {
            sum += card.getPoints();
        }

        return sum;
    }
}
