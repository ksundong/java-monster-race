package dev.idion.monsterrace.io;

import dev.idion.monsterrace.ScoreBoard;
import dev.idion.monsterrace.monster.Monster;

import java.util.Arrays;

import static dev.idion.monsterrace.StringConstants.RESULT_MESSAGE;
import static dev.idion.monsterrace.StringConstants.WINNER_MESSAGE;

public class Printer {
    public void printMonstersMovingDistance(Monster[] monsters) {
        System.out.println(RESULT_MESSAGE);
        Arrays.stream(monsters).forEach(System.out::println);
    }

    public void printWinnerMonster(ScoreBoard scoreBoard) {
        String winnerMonsterName = scoreBoard.buildWinner();
        System.out.printf(WINNER_MESSAGE.toString(), winnerMonsterName);
    }
}
