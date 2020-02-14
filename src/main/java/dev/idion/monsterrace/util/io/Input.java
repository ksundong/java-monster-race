package dev.idion.monsterrace.util.io;

import dev.idion.monsterrace.MainMenu;
import dev.idion.monsterrace.StringConstants;
import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterManagerMenu;
import dev.idion.monsterrace.monster.MonsterType;
import dev.idion.monsterrace.util.datastructure.PositiveInteger;

import java.util.Arrays;
import java.util.Scanner;

import static dev.idion.monsterrace.StringConstants.*;

public class Input {
    private final Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public PositiveInteger selectMenu(StringConstants constants) {
        System.out.println(constants);
        printMenus(constants);
        System.out.print(PROMPT);
        return inputPositiveValue(MENU_NUMBER);
    }

    private void printMenus(StringConstants constants) {
        switch (constants) {
            case PLEASE_SELECT_MENUS_MAIN:
                Arrays.stream(MainMenu.values()).forEach(System.out::println);
                break;
            case PLEASE_SELECT_MENUS_MONSTER:
                Arrays.stream(MonsterManagerMenu.values()).forEach(System.out::println);
                break;
            default:
        }
    }

    public PositiveInteger inputPositiveValue(StringConstants menuNumber) {
        System.out.println(menuNumber + INPUT_MESSAGE.toString());
        System.out.print(PROMPT);
        while (true) {
            try {
                return new PositiveInteger(scanner.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.printf(CORRECT_INPUT_STRING.toString(),
                        menuNumber,
                        e.getMessage(),
                        PROMPT);
            }
        }
    }

    public Monster inputMonsterInfo() {
        while (true) {
            try {
                System.out.println(INPUT_MONSTER_NAME_AND_TYPE);
                System.out.println(SHOW_MONSTER_TYPES);
                System.out.print(PROMPT);
                return getMonsterFromInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Monster getMonsterFromInput() {
        String[] inputs = inputNameAndType();
        String monsterName = inputs[0].trim();
        MonsterType monsterType = MonsterType.valueOfKoreanType(inputs[1].trim());
        return new Monster(monsterName, monsterType);
    }

    private String[] inputNameAndType() {
        String[] inputs = scanner.nextLine().split(",");
        if (inputs.length < 2) {
            throw new IllegalArgumentException(INPUT_CORRECT_MONSTER_NAME_AND_TYPE.toString());
        }
        return inputs;
    }

    public String inputMonsterName() {
        System.out.println(INPUT_MONSTER_NAME);
        System.out.print(PROMPT);
        return scanner.nextLine();
    }

    public boolean checkDeleteMonster() {
        System.out.println(ARE_YOU_SURE_TO_MODIFY_OR_DELETE);
        System.out.print(PROMPT);
        String input = scanner.nextLine().toUpperCase();
        return !input.equals("Y");
    }

    public void close() {
        scanner.close();
    }
}
