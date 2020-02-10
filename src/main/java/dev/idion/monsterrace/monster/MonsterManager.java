package dev.idion.monsterrace.monster;

import dev.idion.monsterrace.io.Input;
import dev.idion.monsterrace.io.MonsterFileReader;
import dev.idion.monsterrace.io.MonsterFileWriter;
import dev.idion.monsterrace.io.Printer;

import java.io.IOException;

import static dev.idion.monsterrace.StringConstants.PLEASE_SELECT_MENUS_MONSTER;
import static dev.idion.monsterrace.StringConstants.THE_NUMBER_IS_NOT_VALID;

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
        boolean loopCondition = true;
        while (loopCondition) {
            loopCondition = selectMonsterMenu();
        }
    }

    private boolean selectMonsterMenu() {
        switch (input.selectMenu(PLEASE_SELECT_MENUS_MONSTER)) {
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                close();
                return false;
            default:
                System.out.println(THE_NUMBER_IS_NOT_VALID);
                return true;
        }
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
