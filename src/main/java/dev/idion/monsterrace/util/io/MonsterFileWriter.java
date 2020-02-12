package dev.idion.monsterrace.util.io;

import dev.idion.monsterrace.monster.MonsterCage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static dev.idion.monsterrace.StringConstants.STORE_FILE_NAME;

public class MonsterFileWriter {
    private PrintWriter fileWriter;

    public MonsterFileWriter() throws IOException {
        this.fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(STORE_FILE_NAME.toString())));
    }

    public void commit(MonsterCage monsterCage) {
        monsterCage.getMonsters().forEach(monster -> fileWriter.println(monster.toCsvString()));
    }

    public void close() {
        fileWriter.close();
    }
}
