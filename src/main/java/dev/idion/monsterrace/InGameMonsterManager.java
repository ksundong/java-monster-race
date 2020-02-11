package dev.idion.monsterrace;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.monster.Monster;

import java.util.Arrays;

import static dev.idion.monsterrace.StringConstants.ATTEMPT_COUNT_STRING;

public class InGameMonsterManager {
    private int attemptCount;
    private Monster[] monsters;
    private Input input;

    public InGameMonsterManager(Input input) {
        this.input = input;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void inputAttemptCount() {
        attemptCount = input.inputPositiveValue(ATTEMPT_COUNT_STRING);
    }

    public void moveMonsters() {
        Arrays.stream(monsters).forEach(this::moveMonster);
    }

    private void moveMonster(Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            monster.move();
        }
    }
}
