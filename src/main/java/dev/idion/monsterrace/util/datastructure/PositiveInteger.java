package dev.idion.monsterrace.util.datastructure;

import static dev.idion.monsterrace.StringConstants.THE_NUMBER_MUST_BE_POSITIVE_VALUE;

public class PositiveInteger {
    private final int positiveInt;

    public PositiveInteger(String input) {
        int integer = Integer.parseInt(input);
        if (integer < 1) {
            throw new NumberFormatException(THE_NUMBER_MUST_BE_POSITIVE_VALUE.toString());
        }
        this.positiveInt = integer;
    }

    public int getPositiveInt() {
        return positiveInt;
    }
}
