package dev.idion.monsterrace.monster;

import dev.idion.monsterrace.util.io.MonsterFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static dev.idion.monsterrace.StringConstants.MONSTER_NOT_EXISTS;
import static dev.idion.monsterrace.StringConstants.THERE_IS_NO_MONSTER;
import static dev.idion.monsterrace.StringConstants.THE_MONSTER_IS_EXIST;

public class MonsterCage {
    private final MonsterFileReader monsterFileReader;
    private final Map<String, Monster> monsterMap;

    public MonsterCage() throws FileNotFoundException {
        this.monsterFileReader = new MonsterFileReader();
        this.monsterMap = monsterFileReader.makeMonsterMap();
    }

    public MonsterCage(Map<String, Monster> testMonsterMap) {
        this.monsterFileReader = null;
        this.monsterMap = testMonsterMap;
    }

    public boolean isEmpty() {
        if (monsterMap.size() == 0) {
            System.out.println(THERE_IS_NO_MONSTER);
            return true;
        }
        return false;
    }

    public List<Monster> getMonsters() {
        return new ArrayList<>(monsterMap.values());
    }

    public void remove(String monsterName) {
        monsterMap.remove(monsterName);
    }

    public void put(String monsterName, Monster monster) {
        monsterMap.put(monsterName, monster);
    }

    public boolean containsMonster(String monsterName) {
        return containsMonster(monsterName, false);
    }

    public boolean containsMonster(String monsterName, boolean showExistFlag) {
        boolean isContain = monsterMap.containsKey(monsterName);
        if (isContain && showExistFlag) {
            System.out.println(THE_MONSTER_IS_EXIST);
        } else if (!isContain) {
            System.out.printf(MONSTER_NOT_EXISTS.toString(), monsterName);
        }
        return isContain;
    }

    public void close() throws IOException {
        monsterFileReader.close();
    }
}
