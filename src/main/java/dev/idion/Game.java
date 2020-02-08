package dev.idion;

import java.security.NoSuchAlgorithmException;
import java.util.*;

import static dev.idion.StringConstants.*;

public class Game {
    Scanner scanner;
    int attemptCount;
    Monster[] monsters;
    Map<Integer, List<String>> rankMap;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.rankMap = new HashMap<>();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.readyGame();
        game.startGame();
        game.printGameResult();
        game.terminateGame(0); // Normal Shutdown
    }

    private void readyGame() {
        System.out.println(GAME_NAME);
        initializeMonsters();
        attemptCount = inputValue(ATTEMPT_COUNT_STRING);
    }

    private void initializeMonsters() {
        monsters = new Monster[inputValue(MONSTER_COUNT_STRING)];
        System.out.println(INPUT_MONSTER_NAME_AND_TYPE);
        for (int i = 0; i < monsters.length; i++) {
            makeMonster(i);
        }
    }

    private void makeMonster(int index) {
        while (true) {
            try {
                System.out.print(PROMPT);
                String[] inputs = scanner.nextLine().split(",");
                String monsterName = inputs[0].trim();
                MonsterType monsterType = MonsterType.valueOf(inputs[1].trim());
                monsters[index] = new Monster(monsterName, monsterType);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(TYPE_NOT_EXIST);
            }
        }
    }

    private int inputValue(StringConstants inputType) {
        System.out.println(inputType + INPUT_MESSAGE.toString());
        System.out.print(PROMPT);
        while (true) {
            try {
                int count = Integer.parseInt(scanner.nextLine());
                validateInputValue(count);
                return count;
            } catch (NumberFormatException e) {
                System.out.printf(CORRECT_INPUT_STRING.toString(), inputType, PROMPT);
            }
        }
    }

    private void validateInputValue(int count) {
        if (count < 1) {
            throw new NumberFormatException(THE_NUMBER_MUST_BE_POSITIVE_VALUE.toString());
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
            try {
                monster.move();
            } catch (NoSuchAlgorithmException e) {
                System.out.println(ERROR_MESSAGE);
                terminateGame(126);
            }
        }
    }

    private void printGameResult() {
        printMonstersMovingDistance();
        printWinnerMonster();
    }

    private void printMonstersMovingDistance() {
        System.out.println(RESULT_MESSAGE);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }

    private void printWinnerMonster() {
        String winnerMonsterName = buildWinner(rankMonsters());
        System.out.printf(WINNER_MESSAGE.toString(), winnerMonsterName);
    }

    private int rankMonsters() {
        int winnerMoveCount = 0;
        for (Monster monster : monsters) {
            int moveCount = monster.getMoveCount();
            winnerMoveCount = Math.max(winnerMoveCount, moveCount);
            List<String> winners = rankMap.getOrDefault(moveCount, new ArrayList<>());
            winners.add(monster.getMonsterName());
            rankMap.put(moveCount, winners);
        }
        return winnerMoveCount;
    }

    private String buildWinner(int maxMoveCount) {
        StringBuilder winnerBuilder = new StringBuilder();
        List<String> winners = rankMap.get(maxMoveCount);
        winners.forEach(winner -> winnerBuilder.append(winner).append(", "));
        winnerBuilder.delete(winnerBuilder.lastIndexOf(","), winnerBuilder.length());
        return winnerBuilder.toString();
    }

    private void terminateGame(int exitStatus) {
        System.out.println(GAME_EXIT_MESSAGE);
        scanner.close();
        System.exit(exitStatus);
    }
}
