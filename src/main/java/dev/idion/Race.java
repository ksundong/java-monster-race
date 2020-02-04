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
        race.terminateGame();
    }

    private void terminateGame() {
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
