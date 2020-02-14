package dev.idion.monsterrace;

import dev.idion.monsterrace.monster.MonsterManager;
import dev.idion.monsterrace.util.io.Input;
import dev.idion.monsterrace.util.io.Printer;

import java.io.IOException;

import static dev.idion.monsterrace.StringConstants.GAME_EXIT_MESSAGE;
import static dev.idion.monsterrace.StringConstants.GAME_NAME;
import static dev.idion.monsterrace.StringConstants.PLEASE_SELECT_MENUS_MAIN;

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
        boolean loopCondition = true;
        while (loopCondition) {
            try {
                loopCondition = game.selectMenu();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
        game.terminateGame();
    }

    private boolean selectMenu() throws IOException {
        switch (input.selectMenu(PLEASE_SELECT_MENUS_MAIN).getPositiveInt()) {
            case 1:
                return new MonsterManager(input).waitInputMenuNumber();
            case 2:
                return playGame();
            case 3:
                return exitGameMenu();
            default:
                return printer.printNotValidNumber();
        }
    }

    private boolean playGame() {
        startGame();
        printer.printGameResult(inGameMonsterManager, scoreBoard);
        return true;
    }

    private boolean exitGameMenu() {
        return false;
    }

    private void startGame() {
        System.out.println(GAME_NAME);
        inGameMonsterManager.setMonstersFromFile();
        inGameMonsterManager.inputAttemptCount();
        inGameMonsterManager.moveMonsters();
        scoreBoard.rankMonsters(inGameMonsterManager.getMonsters());
    }

    private void terminateGame() {
        System.out.println(GAME_EXIT_MESSAGE);
        input.close();
        System.exit(0);
    }
}
