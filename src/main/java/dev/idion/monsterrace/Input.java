package dev.idion.monsterrace;

import java.util.Scanner;

import static dev.idion.monsterrace.StringConstants.CORRECT_INPUT_STRING;
import static dev.idion.monsterrace.StringConstants.INPUT_MESSAGE;
import static dev.idion.monsterrace.StringConstants.PROMPT;
import static dev.idion.monsterrace.StringConstants.THE_NUMBER_MUST_BE_POSITIVE_VALUE;

public class Input {
    private Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputValue(StringConstants inputType) {
        System.out.println(inputType + INPUT_MESSAGE.toString());
        System.out.print(PROMPT);
        while (true) {
            try {
                return getCheckedIntegerValue(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.printf(CORRECT_INPUT_STRING.toString(), inputType, PROMPT);
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
        String monsterName = inputs[0].trim();
        MonsterType monsterType = MonsterType.valueOf(inputs[1].trim());
        return new Monster(monsterName, monsterType);
    }

    public void close() {
        if (scanner != null) scanner.close();
    }
}
