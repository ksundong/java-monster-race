package dev.idion.monsterrace.monster;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.io.MonsterFileReader;
import dev.idion.monsterrace.io.MonsterFileWriter;
import dev.idion.monsterrace.io.Printer;

import java.io.IOException;

public class MonsterManager {
    private final Input input;
    private final Printer printer;
    private final MonsterFileReader monsterFileReader;
    private final MonsterFileWriter monsterFileWriter;

    public MonsterManager(Input input, Printer printer) {
        this.input = input;
        this.printer = printer;
        this.monsterFileReader = new MonsterFileReader();
        this.monsterFileWriter = new MonsterFileWriter();
        selectMonsterMenu();
    }

    private void selectMonsterMenu() {
    }

    private void close() {
        try {
            monsterFileReader.close();
            monsterFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
