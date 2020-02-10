package dev.idion.monsterrace.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MonsterFileReader {
    private FileReader fileReader;

    public MonsterFileReader() {
        try {
            this.fileReader = new FileReader("monster.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        fileReader.close();
    }
}
