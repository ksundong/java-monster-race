package dev.idion.monsterrace;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.io.Printer;
import dev.idion.monsterrace.monster.MonsterManager;

import java.io.IOException;

import static dev.idion.monsterrace.StringConstants.GAME_EXIT_MESSAGE;
import static dev.idion.monsterrace.StringConstants.GAME_NAME;
import static dev.idion.monsterrace.StringConstants.PLEASE_SELECT_MENUS_MAIN;
import static dev.idion.monsterrace.StringConstants.THE_NUMBER_IS_NOT_VALID;

public class Game {
    private final InGameMonsterManager inGameMonsterManager;
    private final ScoreBoard scoreBoard;
    private final Input input;
    private final Printer printer;

    public Game() {
        this.scoreBoard = new ScoreBoard();
        this.input = new Input();
        this.printer = new Printer();
        this.inGameMonsterManager = new InGameMonsterManager(input);
    }

    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            try {
                game.selectMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void selectMenu() throws IOException {
        switch (input.selectMenu(PLEASE_SELECT_MENUS_MAIN)) {
            case 1:
                new MonsterManager(input);
                break;
            case 2:
                readyGame();
                startGame();
                printGameResult();
                terminateGame();
                break;
            default:
                System.out.println(THE_NUMBER_IS_NOT_VALID);
        }
    }

    private void readyGame() {
        System.out.println(GAME_NAME);
        inGameMonsterManager.inputAttemptCount();
    }

    private void startGame() {
        inGameMonsterManager.moveMonsters();
        scoreBoard.rankMonsters(inGameMonsterManager.getMonsters());
    }

    private void printGameResult() {
        printer.printMonstersMovingDistance(inGameMonsterManager.getMonsters());
        printer.printWinnerMonster(scoreBoard);
    }

    private void terminateGame() {
        System.out.println(GAME_EXIT_MESSAGE);
        input.close();
        System.exit(0);
    }
}
