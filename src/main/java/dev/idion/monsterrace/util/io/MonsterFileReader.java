package dev.idion.monsterrace.util.io;

import dev.idion.monsterrace.monster.Monster;
import dev.idion.monsterrace.monster.MonsterType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            Monster monster = makeMonster();
            if (monster == null) break;
            monsterMap.put(monster.getMonsterName(), monster);
        }
        return monsterMap;
    }

    public Monster makeMonster() {
        try {
            String line = fileReader.readLine();
            String[] data = line.split(",");
            return new Monster(data[0], MonsterType.valueOfKoreanType(data[1]));
        } catch (IOException | NullPointerException e) {
            return null;
        }
    }

    public List<Monster> getMonstersFromFile() {
        Map<String, Monster> monsterMap = makeMonsterMap();
        if (monsterMap.size() == 0) throw new IllegalStateException(THERE_IS_NO_MONSTER.toString());
        return new ArrayList<>(monsterMap.values());
    }

    public void close() throws IOException {
        fileReader.close();
    }
}
