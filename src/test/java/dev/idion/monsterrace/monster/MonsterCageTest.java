package dev.idion.monsterrace.monster;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MonsterCageTest {
    MonsterCage monsterCage;
    Monster first;
    Monster second;
    Monster third;

    @BeforeEach
    void setUp() {
        first = new Monster("디온", MonsterType.valueOfKoreanType("달리기"));
        second = new Monster("나는애", MonsterType.valueOfKoreanType("비행"));
        third = new Monster("이상한애", MonsterType.valueOfKoreanType("에스퍼"));

        Map<String, Monster> monsterMap = new HashMap<>();
        monsterMap.put("디온", first);
        monsterMap.put("나는애", second);
        monsterMap.put("이상한애", third);
        monsterCage = new MonsterCage(monsterMap);
    }

    @Test
    void testIsEmpty() {
        boolean expected = false;
        boolean actual = monsterCage.isEmpty();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testGetMonsters() {
        List<Monster> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);
        List<Monster> actual = monsterCage.getMonsters();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testRemove() {
        List<Monster> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);

        monsterCage.remove("이상한애");
        List<Monster> actual = monsterCage.getMonsters();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testPut() {
        Monster newMonster = new Monster("새로운애", MonsterType.valueOfKoreanType("달리기"));

        List<Monster> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        expected.add(third);
        expected.add(newMonster);

        monsterCage.put("새로운애", newMonster);
        List<Monster> actual = monsterCage.getMonsters();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testContainsMonster() {
        boolean expected = true;
        boolean actual = monsterCage.containsMonster("디온");
        assertThat(actual).isEqualTo(expected);
    }
}
