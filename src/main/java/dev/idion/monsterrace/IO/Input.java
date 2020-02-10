package dev.idion.monsterrace.IO;

import dev.idion.monsterrace.MainMenu;
import dev.idion.monsterrace.Monster;
import dev.idion.monsterrace.MonsterType;
import dev.idion.monsterrace.StringConstants;

import java.util.Arrays;
import java.util.Scanner;

import static dev.idion.monsterrace.StringConstants.*;

public class Input {
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int selectMenu() {
        System.out.println(PLEASE_SELECT_MENUS);
        Arrays.stream(MainMenu.values()).forEach(System.out::println);
        System.out.print(PROMPT);
        while (true) {
            try {
                return getCheckedIntegerValue(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.printf(CORRECT_INPUT_STRING.toString(),
                        MENU_NUMBER,
                        e.getMessage(),
                        PROMPT);
            }
        }
    }

    public int inputValue(StringConstants inputType) {
        System.out.println(inputType + INPUT_MESSAGE.toString());
        System.out.print(PROMPT);
        while (true) {
            try {
                return getCheckedIntegerValue(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.printf(CORRECT_INPUT_STRING.toString(), inputType, e.getMessage(), PROMPT);
            }
        }
    }

    private int getCheckedIntegerValue(String input) {
        int integer = Integer.parseInt(input);
        if (integer < 1) {
            throw new NumberFormatException(THE_NUMBER_MUST_BE_POSITIVE_VALUE.toString());
        }
        return integer;
    }

    public Monster inputMonsterInfo() {
        System.out.print(PROMPT);
        String[] inputs = scanner.nextLine().split(",");
        if (inputs.length < 2) {
            throw new ArrayIndexOutOfBoundsException(INPUT_CORRECT_MONSTER_NAME_AND_TYPE.toString());
        }
        String monsterName = inputs[0].trim();
        MonsterType monsterType = MonsterType.valueOf(inputs[1].trim());
        return new Monster(monsterName, monsterType);
    }

    public void close() {
        if (scanner != null) scanner.close();
    }
}
