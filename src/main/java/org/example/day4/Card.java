package org.example.day4;

import java.util.List;

public record Card(int id, List<Integer> winningNumbers, List<Integer> playerNumbers) {
    public int getPoints() {
        int result = 0;
        for (var playerNumber : playerNumbers) {
            if (winningNumbers.contains(playerNumber)) {
                result = result == 0 ? 1 : result * 2;
            }
        }

        return result;
    }
}
