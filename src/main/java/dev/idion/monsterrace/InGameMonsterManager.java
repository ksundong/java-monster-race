package dev.idion.monsterrace;

import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.util.io.Input;
import dev.idion.monsterrace.util.io.MonsterFileReader;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import static dev.idion.monsterrace.StringConstants.ATTEMPT_COUNT_STRING;

public class InGameMonsterManager {
    private int attemptCount;
    private List<Monster> monsters;
    private final Input input;
    private final Random random;

    public InGameMonsterManager(Input input) {
        this.input = input;
        this.random = new Random();
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void inputAttemptCount() {
        attemptCount = input.inputPositiveValue(ATTEMPT_COUNT_STRING).getPositiveInt();
    }

    public void moveMonsters() {
        monsters.forEach(this::moveMonster);
    }

    private void moveMonster(Monster monster) {
        for (int i = 0; i < attemptCount; i++) {
            monster.move(random);
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
