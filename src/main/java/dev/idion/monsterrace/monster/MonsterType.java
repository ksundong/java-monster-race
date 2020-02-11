package dev.idion.monsterrace.monster;

import java.util.Arrays;
import java.util.Random;

import static dev.idion.monsterrace.StringConstants.TYPE_NOT_EXIST;

public enum MonsterType {
    RUNNER("달리기") {
        @Override
        public int moveMonster(Random random) {
            return random.nextInt(10) >= 4 ? 1 : 0;
        }
    }, FLYING("비행") {
        @Override
        public int moveMonster(Random random) {
            return random.nextInt(10) >= 6 ? 3 : 0;
        }
    }, ESPURR("에스퍼") {
        @Override
        public int moveMonster(Random random) {
            return random.nextInt(10) == 9 ? random.nextInt(99) + 1 : 0;
        }
    };

    private final String koreanType;

    MonsterType(String koreanType) {
        this.koreanType = koreanType;
    }

    public static MonsterType valueOfKoreanType(String inputMessage) {
        return Arrays.stream(MonsterType.values())
                     .filter(monsterType -> inputMessage.equals(monsterType.koreanType))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(String.format(TYPE_NOT_EXIST.toString(),
                             inputMessage)));
    }

    abstract int moveMonster(Random random);

    @Override
    public String toString() {
        return koreanType;
    }
}
