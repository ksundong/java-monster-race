package dev.idion.monsterrace.util.io;

import dev.idion.monsterrace.ScoreBoard;
import dev.idion.monsterrace.monster.Monster;

import java.util.List;

import static dev.idion.monsterrace.StringConstants.RESULT_MESSAGE;
import static dev.idion.monsterrace.StringConstants.WINNER_MESSAGE;

public class Printer {
    public void printMonstersMovingDistance(List<Monster> monsters) {
        System.out.println(RESULT_MESSAGE);
        monsters.stream().map(Monster::getMovingDistance).forEach(System.out::println);
    }

    public void printWinnerMonster(ScoreBoard scoreBoard) {
        System.out.printf(WINNER_MESSAGE.toString(), scoreBoard.getWinnerName());
    }
}
