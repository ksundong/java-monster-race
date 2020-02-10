package dev.idion.monsterrace;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.io.Printer;
import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterManager;

import java.util.*;
import java.util.stream.IntStream;

import static dev.idion.monsterrace.StringConstants.*;

public class Game {
    private int attemptCount;
    private int winnerMoveCount;
    private Monster[] monsters;
    private final Map<Integer, List<String>> rankMap;
    private final Input input;
    private final Printer printer;

    public Game() {
        this.rankMap = new HashMap<>();
        this.input = new Input(new Scanner(System.in));
        this.printer = new Printer();
    }

    public static void main(String[] args) {
        Game game = new Game();
        while (true) {
            game.selectMenu();
        }
    }

    public void selectMenu() {
        switch (input.selectMenu()) {
            case 1:
                new MonsterManager(input, printer);
                break;
            case 2:
                this.readyGame();
                this.startGame();
                this.rankMonsters();
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
        IntStream.range(0, monsters.length).forEach(this::makeMonster);
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
        randomAttempt();
    }

    private void randomAttempt() {
        Arrays.stream(monsters).forEach(this::attemptMoveMonster);
    }

    private void attemptMoveMonster(Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            monster.move();
        }
    }

    private void printGameResult() {
        printer.printMonstersMovingDistance(monsters);
        printer.printWinnerMonster(rankMap, winnerMoveCount);
    }

    private void rankMonsters() {
        Arrays.stream(monsters)
                .forEach(monster -> {
                    int moveCount = monster.getMoveCount();
                    winnerMoveCount = Math.max(winnerMoveCount, moveCount);
                    List<String> winners = rankMap.getOrDefault(moveCount, new ArrayList<>());
                    winners.add(monster.getMonsterName());
                    rankMap.put(moveCount, winners);
                });
    }

    private void terminateGame() {
        System.out.println(GAME_EXIT_MESSAGE);
        input.close();
        System.exit(0);
    }
}
