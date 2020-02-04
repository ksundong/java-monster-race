package dev.idion;

import java.util.Scanner;

public class Race {
    private static final String PROMPT = "> ";
    Scanner scanner;

    public Race() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.readyGame();
        race.terminateGame(0); // Normal Shutdown
    }

    private void readyGame() {
        System.out.println("<몬스터 경주>");
        inputMonsterCount();
    }

    private void inputMonsterCount() {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        System.out.print(PROMPT);
        String input = scanner.nextLine();
        int count = 0;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("몬스터의 수를 정확히 입력해주세요.");
            terminateGame(1); // Unix "Catchall for general errors"
        }
    }
    private void terminateGame(int exitStatus) {
        System.out.println("게임을 종료합니다.");
        scanner.close();
        System.exit(exitStatus);
    }
}
