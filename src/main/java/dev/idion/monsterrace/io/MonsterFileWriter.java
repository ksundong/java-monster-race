package dev.idion.monsterrace.io;

import dev.idion.monsterrace.monster.Monster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import static dev.idion.monsterrace.StringConstants.STORE_FILE_NAME;

public class MonsterFileWriter {
    private PrintWriter fileWriter;

    public MonsterFileWriter() throws IOException {
        this.fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(STORE_FILE_NAME.toString(),
                false)));
    }

    public void commit(Map<String, Monster> monsterMap) {
        monsterMap.keySet()
                  .stream()
                  .map(monsterMap::get)
                  .forEach(monster -> fileWriter.println(monster.toCsvString()));
    }

    public void close() {
        fileWriter.close();
    }
}
