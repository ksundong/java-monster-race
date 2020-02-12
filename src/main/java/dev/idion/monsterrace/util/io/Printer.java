package dev.idion.monsterrace.util.io;

import dev.idion.monsterrace.ScoreBoard;
import dev.idion.monsterrace.monster.Monster;

import java.util.Arrays;

import static dev.idion.monsterrace.StringConstants.RESULT_MESSAGE;
import static dev.idion.monsterrace.StringConstants.WINNER_MESSAGE;

public class Printer {
    public void printMonstersMovingDistance(Monster[] monsters) {
        System.out.println(RESULT_MESSAGE);
        Arrays.stream(monsters).forEach(m -> System.out.println(m.getMovingDistance()));
    }

    public void printWinnerMonster(ScoreBoard scoreBoard) {
        System.out.printf(WINNER_MESSAGE.toString(), scoreBoard.getWinnerName());
    }
}
