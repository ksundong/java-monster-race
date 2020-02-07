package dev.idion;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Race {
    private static final String PROMPT = "> ";
    private static final String GAME_NAME = "<심심한 몬스터 경주>";
    private static final String INPUT_MESSAGE = "를 입력해주세요.";
    private static final String MONSTER_COUNT_STRING = "몬스터의 수";
    private static final String ATTEMPT_COUNT_STRING = "시도할 횟수";
    private static final String CORRECT_INPUT_STRING = "%s를 정확히 입력해주세요.%n%s";
    private static final String THE_NUMBER_MUST_BE_POSITIVE_VALUE = "숫자는 양수여야 합니다.";
    private static final String ERROR_MESSAGE = "게임 실행 도중 오류가 발생했습니다.";
    private static final String RESULT_MESSAGE = "<실행 결과>";
    private static final String GAME_EXIT_MESSAGE = "게임을 종료합니다.";
    Scanner scanner;
    int attemptCount;
    Monster[] monsters;

    public Race() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.readyGame();
        race.startGame();
        race.endGame();
        race.terminateGame(0); // Normal Shutdown
    }

    private void readyGame() {
        System.out.println(GAME_NAME);
        initializeMonsters();
        attemptCount = inputValue(ATTEMPT_COUNT_STRING);
    }

    private void initializeMonsters() {
        monsters = new Monster[inputValue(MONSTER_COUNT_STRING)];
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Monster();
        }
    }

    private int inputValue(String inputType) {
        System.out.println(inputType + INPUT_MESSAGE);
        System.out.print(PROMPT);
        while (true) {
            try {
                int count = Integer.parseInt(scanner.nextLine());
                validateInputValue(count);
                return count;
            } catch (NumberFormatException e) {
                System.out.printf(CORRECT_INPUT_STRING, inputType, PROMPT);
            }
        }
    }

    private void validateInputValue(int count) {
        if (count < 1) {
            throw new NumberFormatException(THE_NUMBER_MUST_BE_POSITIVE_VALUE);
        }
    }

    private void startGame() {
        try {
            randomAttempt();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(ERROR_MESSAGE);
            terminateGame(126); // Unix "Command invoked cannot execute"
        }
    }

    private void randomAttempt() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        for (Monster monster : monsters) {
            attemptMoveMonster(random, monster);
        }
    }

    private void attemptMoveMonster(Random random, Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            moveMonster(random, monster);
        }
    }

    private void moveMonster(Random random, Monster monster) {
        if (random.nextInt(10) > 3) {
            monster.plusMoveCount();
        }
    }

    private void endGame() {
        printMonstersMovingDistance();
    }

    private void printMonstersMovingDistance() {
        System.out.println(RESULT_MESSAGE);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }

    private void terminateGame(int exitStatus) {
        System.out.println(GAME_EXIT_MESSAGE);
        scanner.close();
        System.exit(exitStatus);
    }
}
