package dev.idion.monsterrace.monster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class MonsterTest {
    Monster run;
    Monster fly;
    Monster espurr;

    @BeforeEach
    void setUp() {
        run = new Monster("달리는애", MonsterType.valueOfKoreanType("달리기"));
        fly = new Monster("나는애", MonsterType.valueOfKoreanType("비행"));
        espurr = new Monster("이상한애", MonsterType.valueOfKoreanType("에스퍼"));
    }

    @Test
    void testRunMove() {
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        run.move(random);
        int expected = 1;
        int actual = run.getMoveCount();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testFlyMove() {
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 7;
            }
        };
        fly.move(random);
        int expected = 3;
        int actual = fly.getMoveCount();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEspurrMove() {
        Random random = new Random() {
            private boolean first = true;

            @Override
            public int nextInt(int bound) {
                if (first) {
                    first = false;
                    return 9;
                }
                return 32;
            }
        };
        espurr.move(random);
        int expected = 33;
        int actual = espurr.getMoveCount();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getMoveCount() {
        run.move(new Random());
        run.getMoveCount();
    }

    @Test
    void getMonsterName() {
        String expected = "달리는애";
        String actual = run.getMonsterName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toCsvString() {
        String expected = "달리는애,달리기";
        String actual = run.toCsvString();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getMovingDistance() {
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 5;
            }
        };
        run.move(random);
        String expected = "달리는애 [달리기] : -";
        String actual = run.getMovingDistance();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testToString() {
        String expected = "달리는애 [달리기]";
        String actual = run.toString();
        assertThat(actual).isEqualTo(expected);
    }
}
