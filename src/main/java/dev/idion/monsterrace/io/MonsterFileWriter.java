package dev.idion.monsterrace.io;

import java.io.FileWriter;
import java.io.IOException;

public class MonsterFileWriter {
    private FileWriter fileWriter;

    public MonsterFileWriter() {
        try {
            this.fileWriter = new FileWriter("monster.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
