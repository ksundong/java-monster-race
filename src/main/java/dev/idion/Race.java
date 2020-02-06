package dev.idion;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Race {
    private static final String PROMPT = "> ";
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
        System.out.println("<몬스터 경주>");
        monsters = new Monster[inputMonsterCount()];
        fillMonsterIntoMonsters();
        inputAttemptCount();
    }

    private void fillMonsterIntoMonsters() {
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Monster();
        }
    }

    private int inputMonsterCount() {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        System.out.print(PROMPT);
        Integer count = null;
        while (count == null) {
            count = inputIntTypeValue("몬스터의 수");
        }
        return count;
    }

    private void inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        System.out.print(PROMPT);
        Integer count = null;
        while (count == null) {
            count = inputIntTypeValue("시도할 횟수");
        }
        attemptCount = count;
    }

    private Integer inputIntTypeValue(String targetErrorMessage) {
        try {
            int inputValue = Integer.parseInt(scanner.nextLine());
            validateInputValue(inputValue);
            return inputValue;
        } catch (NumberFormatException e) {
            System.out.printf("%s를 정확히 입력해주세요.%n%s", targetErrorMessage, PROMPT);
        }
        return null;
    }

    private void validateInputValue(int count) {
        if (count < 1) {
            throw new NumberFormatException("숫자는 양수여야 합니다.");
        }
    }

    private void startGame() {
        try {
            randomAttempt();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("게임 실행 도중 오류가 발생했습니다.");
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
        System.out.println("<실행 결과>");
        for (Monster monster : monsters) {
            monster.showMovingDistance();
        }
    }

    private void terminateGame(int exitStatus) {
        System.out.println("게임을 종료합니다.");
        scanner.close();
        System.exit(exitStatus);
    }
}
