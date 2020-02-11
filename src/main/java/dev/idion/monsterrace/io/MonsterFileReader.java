package dev.idion.monsterrace.io;

import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterType;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MonsterFileReader {
    private FileReader fileReader;

    public MonsterFileReader() {
        try {
            this.fileReader = new FileReader("monster.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Monster> makeMonsterMap() {
        Map<String, Monster> monsterMap = new HashMap<>();
        return monsterMap;
    }

    public Monster makeMonster() {
        return new Monster("디온", MonsterType.valueOfKoreanType("비행"));
    }

    public void close() throws IOException {
        fileReader.close();
    }
}
