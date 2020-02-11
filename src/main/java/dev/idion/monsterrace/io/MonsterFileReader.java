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

    public void close() throws IOException {
        fileReader.close();
    }
}
