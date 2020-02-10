package dev.idion.monsterrace;

import java.util.Random;

public class Monster implements Movable {
    private int moveCount;
    private final String monsterName;
    private final MonsterType monsterType;

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
        StringBuilder monsterDistanceBuilder = new StringBuilder();
        monsterDistanceBuilder.append(monsterName).append(" [").append(monsterType).append("] : ");
        for (int i = 0; i < moveCount; i++) {
            monsterDistanceBuilder.append("-");
        }
        return monsterDistanceBuilder.toString();
    }
}
