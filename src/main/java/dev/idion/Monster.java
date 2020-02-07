package dev.idion;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class Monster {
    private int moveCount;
    private String monsterName;
    private MonsterType monsterType;

    public Monster(String monsterName, MonsterType monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }

    public void moveMonster() throws NoSuchAlgorithmException {
        moveCount += randomMove();
    }

    private int randomMove() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        int randomValue = random.nextInt(10);
        switch (monsterType) {
            case 달리기:
                return randomValue >= 4 ? 1 : 0;
            case 비행:
                return randomValue >= 6 ? 3 : 0;
            case 에스퍼:
                return randomValue == 9 ? random.nextInt(99) + 1 : 0;
            default:
                return 0;
        }
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
