package dev.idion.monsterrace.io;

import dev.idion.monsterrace.monster.Monster;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MonsterFileWriter {
    private FileWriter fileWriter;

    public MonsterFileWriter() {
        try {
            this.fileWriter = new FileWriter("monster.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void commit(Map<String, Monster> monsterMap) {
        // TODO: Write File Logic.
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
