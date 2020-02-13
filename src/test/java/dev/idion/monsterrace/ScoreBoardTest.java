package dev.idion.monsterrace;

import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreBoardTest {
    ScoreBoard scoreBoard;
    List<Monster> monsters;
    Monster dion;
    Monster gugu;
    Monster gorapaduck;
    Monster kkorat;
    Random runRandom = new Random() {
        @Override
        public int nextInt(int bound) {
            return 4;
        }
    };
    Random flyRandom = new Random() {
        @Override
        public int nextInt(int bound) {
            return 7;
        }
    };

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
        monsters = new ArrayList<>();
        dion = new Monster("디온", MonsterType.valueOfKoreanType("달리기"));
        gugu = new Monster("구구", MonsterType.valueOfKoreanType("비행"));
        gorapaduck = new Monster("고라파덕", MonsterType.valueOfKoreanType("에스퍼"));
        kkorat = new Monster("꼬렛", MonsterType.valueOfKoreanType("달리기"));

        Random espurrRandom = new Random() {
            private boolean first = true;

            @Override
            public int nextInt(int bound) {
                if (first) {
                    first = false;
                    return 9;
                }
                return 8;
            }
        };

        for (int i = 0; i < 5; i++) {
            dion.move(runRandom);
        }
        for (int i = 0; i < 3; i++) {
            gugu.move(flyRandom);
        }
        gorapaduck.move(espurrRandom);
        for (int i = 0; i < 8; i++) {
            kkorat.move(runRandom);
        }

        monsters.add(dion);
        monsters.add(gugu);
        monsters.add(gorapaduck);
        monsters.add(kkorat);
    }

    @Test
    void testRankMonsters() {
        Map<Integer, List<String>> expected = new HashMap<>();
        List<String> firstRankList = new ArrayList<>();
        List<String> secondRankList = new ArrayList<>();
        List<String> thirdRankList = new ArrayList<>();

        firstRankList.add(gugu.getMonsterName());
        firstRankList.add(gorapaduck.getMonsterName());
        secondRankList.add(kkorat.getMonsterName());
        thirdRankList.add(dion.getMonsterName());

        expected.put(9, firstRankList);
        expected.put(8, secondRankList);
        expected.put(5, thirdRankList);

        Map<Integer, List<String>> actual = scoreBoard.rankMonsters(monsters);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testGetWinnerName() {
        scoreBoard.rankMonsters(monsters);

        String expected = "구구, 고라파덕";
        String actual = scoreBoard.getWinnerName();
        assertThat(actual).isEqualTo(expected);
    }
}
