package dev.idion.monsterrace.monster;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.io.MonsterFileReader;
import dev.idion.monsterrace.io.MonsterFileWriter;
import dev.idion.monsterrace.io.Printer;

import java.io.IOException;
import java.util.Arrays;

import static dev.idion.monsterrace.StringConstants.PLEASE_SELECT_MENUS_MONSTER;
import static dev.idion.monsterrace.StringConstants.PROMPT;

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
        close();
    }

    private void selectMonsterMenu() {
        System.out.println(PLEASE_SELECT_MENUS_MONSTER);
        Arrays.stream(MonsterManagerMenu.values()).forEach(System.out::println);
        System.out.print(PROMPT);
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
