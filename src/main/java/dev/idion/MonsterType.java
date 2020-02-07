package dev.idion;

import java.util.Random;

public enum MonsterType {
    달리기,
    비행,
    에스퍼;

    public static int movePerType(Random random, MonsterType monsterType) {
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
}
