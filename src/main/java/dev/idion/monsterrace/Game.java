package dev.idion.monsterrace;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.io.Printer;
import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterManager;

import java.util.Arrays;
import java.util.Scanner;

import static dev.idion.monsterrace.StringConstants.*;

public class Game {
    private int attemptCount;
    private Monster[] monsters;
    private ScoreBoard scoreBoard;
    private final Input input;
    private final Printer printer;

    public Game() {
        this.scoreBoard = new ScoreBoard();
        this.input = new Input(new Scanner(System.in));
        this.printer = new Printer();
    }

    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            game.selectMenu();
        }
    }

    private void selectMenu() {
        switch (input.selectMenu(PLEASE_SELECT_MENUS_MAIN)) {
            case 1:
                new MonsterManager(input, printer);
                break;
            case 2:
                this.readyGame();
                this.startGame();
                scoreBoard.rankMonsters(monsters);
                this.printGameResult();
                this.terminateGame();
                break;
            default:
                System.out.println(THE_NUMBER_IS_NOT_VALID);
        }
    }

    private void readyGame() {
        System.out.println(GAME_NAME);
        initializeMonsters();
        attemptCount = input.inputValue(ATTEMPT_COUNT_STRING);
    }

    private void initializeMonsters() {
        monsters = new Monster[input.inputValue(MONSTER_COUNT_STRING)];
        inputMonstersInfo();
    }

    private void inputMonstersInfo() {
        System.out.println(INPUT_MONSTER_NAME_AND_TYPE);
        System.out.println(SHOW_MONSTER_TYPES);
        int monsterCount = monsters.length;
        for (int i = 0; i < monsterCount; i++) {
            makeMonster(i);
        }
    }

    private void makeMonster(int index) {
        while (true) {
            try {
                monsters[index] = input.inputMonsterInfo();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(TYPE_NOT_EXIST);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void startGame() {
        Arrays.stream(monsters).forEach(this::attemptMoveMonster);
    }

    private void attemptMoveMonster(Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            monster.move();
        }
    }

    private void printGameResult() {
        printer.printMonstersMovingDistance(monsters);
        printer.printWinnerMonster(scoreBoard);
    }

    private void terminateGame() {
        System.out.println(GAME_EXIT_MESSAGE);
        input.close();
        System.exit(0);
    }
}
