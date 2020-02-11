package dev.idion.monsterrace.monster;

import java.util.Random;
import java.util.StringJoiner;

public class Monster implements Movable {
    private final String monsterName;
    private final MonsterType monsterType;
    private int moveCount;

    public Monster(String monsterName, MonsterType monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }

    @Override
    public void move() {
        moveCount += monsterType.moveMonster(new Random());
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getMonsterName() {
        return monsterName;
    }

    @Override
    public String toString() {
        String prefix = String.format("%s [%s] : ", monsterName, monsterType);
        StringJoiner monsterDistance = new StringJoiner("", prefix, "");
        for (int i = 0; i < moveCount; i++) {
            monsterDistance.add("-");
        }
        return monsterDistance.toString();
    }
}
