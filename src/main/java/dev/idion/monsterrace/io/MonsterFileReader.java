package dev.idion.monsterrace.io;

import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static dev.idion.monsterrace.StringConstants.STORE_FILE_NAME;
import static dev.idion.monsterrace.StringConstants.THERE_IS_NO_MONSTER;

public class MonsterFileReader {
    private BufferedReader fileReader;

    public MonsterFileReader() throws FileNotFoundException {
        this.fileReader = new BufferedReader(new FileReader(STORE_FILE_NAME.toString()));
    }

    public Map<String, Monster> makeMonsterMap() {
        Map<String, Monster> monsterMap = new HashMap<>();
        while (true) {
            try {
                Monster monster = makeMonster();
                monsterMap.put(monster.getMonsterName(), monster);
            } catch (IOException e) {
                break;
            }
        }
        return monsterMap;
    }

    public Monster makeMonster() throws IOException {
        String line = fileReader.readLine();
        if (line == null) throw new IOException("Empty Line");
        String[] data = line.split(",");
        return new Monster(data[0], MonsterType.valueOfKoreanType(data[1]));
    }

    public Monster[] getMonstersFromFile() {
        Map<String, Monster> monsterMap = makeMonsterMap();
        int size = monsterMap.size();
        if (size == 0) throw new IllegalStateException(THERE_IS_NO_MONSTER.toString());
        Monster[] monsters = new Monster[size];
        int i = 0;
        for (String key : monsterMap.keySet()) {
            monsters[i] = monsterMap.get(key);
            i++;
        }
        return monsters;
    }

    public void close() throws IOException {
        fileReader.close();
    }
}
