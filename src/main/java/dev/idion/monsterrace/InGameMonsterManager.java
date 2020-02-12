package dev.idion.monsterrace;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.io.MonsterFileReader;
import dev.idion.monsterrace.monster.Monster;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

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
        attemptCount = input.inputPositiveValue(ATTEMPT_COUNT_STRING).getPositiveInt();
    }

    public void moveMonsters() {
        Arrays.stream(monsters).forEach(this::moveMonster);
    }

    private void moveMonster(Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            monster.move(new Random());
        }
    }

    public void setMonstersFromFile() {
        try {
            this.monsters = new MonsterFileReader().getMonstersFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
