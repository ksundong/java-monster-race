package dev.idion.monsterrace.monster;

import java.util.Random;

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

    public String toCsvString() {
        return String.format("%s,%s", monsterName, monsterType);
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", monsterName, monsterType);
    }
}
