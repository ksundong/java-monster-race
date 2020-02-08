package dev.idion.monsterrace;

import java.util.Random;

public enum MonsterType {
    달리기 {
        public int moveMonster(Random random) {
            return random.nextInt(10) >= 4 ? 1 : 0;
        }
    },
    비행{
        public int moveMonster(Random random) {
            return random.nextInt(10) >= 6 ? 3 : 0;
        }
    },
    에스퍼{
        public int moveMonster(Random random) {
            return random.nextInt(10) == 9 ? random.nextInt(99) + 1 : 0;
        }
    };

    abstract int moveMonster(Random random);
}
