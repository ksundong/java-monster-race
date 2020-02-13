package dev.idion.monsterrace;

import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class ScoreBoardTest {
    ScoreBoard scoreBoard;
    List<Monster> monsters;
    Monster dion;
    Monster gugu;
    Monster gorapaduck;
    Monster kkorat;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
        monsters = new ArrayList<>();
        dion = new Monster("디온", MonsterType.valueOfKoreanType("달리기"));
        gugu = new Monster("구구", MonsterType.valueOfKoreanType("비행"));
        gorapaduck = new Monster("고라파덕", MonsterType.valueOfKoreanType("에스퍼"));
        kkorat = new Monster("꼬렛", MonsterType.valueOfKoreanType("달리기"));

        dion.setMoveCount(5);
        gugu.setMoveCount(9);
        gorapaduck.setMoveCount(9);
        kkorat.setMoveCount(8);

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
        fail("실패");
    }
}
