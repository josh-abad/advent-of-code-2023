package org.example.day4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ScratchcardsTest {

    @Test
    void Calculate_scratchcard_pile_points() {
        final CardParser cardParser = new CardParser();
        final List<Card> cards = cardParser.parseToList("/day4/input.txt");
        final Scratchcards scratchcards = new Scratchcards();
        assertEquals(13, scratchcards.calculatePoints(cards));
    }
}
