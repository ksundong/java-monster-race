package dev.idion;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Monster implements Movable {
    private int moveCount;
    private String monsterName;
    private MonsterType monsterType;

    public Monster(String monsterName, MonsterType monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }

    @Override
    public void move() throws NoSuchAlgorithmException {
        moveCount += MonsterType.movePerType(SecureRandom.getInstanceStrong(), monsterType);
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
