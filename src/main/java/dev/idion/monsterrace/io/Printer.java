package dev.idion.monsterrace.io;

import dev.idion.monsterrace.monster.Monster;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static dev.idion.monsterrace.StringConstants.RESULT_MESSAGE;
import static dev.idion.monsterrace.StringConstants.WINNER_MESSAGE;

public class Printer {
    public void printMonstersMovingDistance(Monster[] monsters) {
        System.out.println(RESULT_MESSAGE);
        Arrays.stream(monsters).forEach(System.out::println);
    }

    public void printWinnerMonster(Map<Integer, List<String>> rankMap, int winnerMoveCount) {
        String winnerMonsterName = buildWinner(rankMap, winnerMoveCount);
        System.out.printf(WINNER_MESSAGE.toString(), winnerMonsterName);
    }

    private String buildWinner(Map<Integer, List<String>> rankMap, int winnerMoveCount) {
        StringBuilder winnerBuilder = new StringBuilder();
        List<String> winners = rankMap.get(winnerMoveCount);
        winners.forEach(winner -> winnerBuilder.append(winner).append(", "));
        winnerBuilder.delete(winnerBuilder.lastIndexOf(","), winnerBuilder.length());
        return winnerBuilder.toString();
    }
}
