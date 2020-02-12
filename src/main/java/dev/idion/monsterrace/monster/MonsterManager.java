package dev.idion.monsterrace.monster;

import dev.idion.monsterrace.util.io.Input;
import dev.idion.monsterrace.util.io.MonsterFileReader;
import dev.idion.monsterrace.util.io.MonsterFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static dev.idion.monsterrace.StringConstants.*;

public class MonsterManager {
    private final Input input;
    private final MonsterFileReader monsterFileReader;
    private final MonsterFileWriter monsterFileWriter;
    private final Map<String, Monster> monsterMap;

    public MonsterManager(Input input) throws IOException {
        this.input = input;
        this.monsterFileReader = new MonsterFileReader();
        this.monsterMap = monsterFileReader.makeMonsterMap();
        this.monsterFileWriter = new MonsterFileWriter();
        waitInputMenuNumber();
    }

    private void waitInputMenuNumber() {
        boolean loopCondition = true;
        while (loopCondition) {
            loopCondition = selectMonsterMenu();
        }
        this.close();
    }

    private boolean selectMonsterMenu() {
        switch (input.selectMenu(PLEASE_SELECT_MENUS_MONSTER).getPositiveInt()) {
            case 1:
                showAllMonsters();
                return true;
            case 2:
                modifyMonsterInfo();
                return true;
            case 3:
                addNewMonsterInfo();
                return true;
            case 4:
                deleteMonsterInfo();
                return true;
            case 5:
                return false;
            default:
                System.out.println(THE_NUMBER_IS_NOT_VALID);
                return true;
        }
    }

    public boolean checkMonsterMap() {
        if (monsterMap.size() == 0) {
            System.out.println(THERE_IS_NO_MONSTER);
            return true;
        }
        return false;
    }

    private void showAllMonsters() {
        if (checkMonsterMap()) return;
        getMonsters().forEach(System.out::println);
    }

    public List<Monster> getMonsters() {
        return new ArrayList<>(monsterMap.values());
    }

    private void modifyMonsterInfo() {
        if (checkMonsterMap()) return;
        String monsterName = input.inputMonsterName();
        if (checkMonsterNotExist(monsterName)) return;
        if (input.checkDeleteMonster()) return;
        Monster newMonster = input.inputMonsterInfo();
        monsterMap.remove(monsterName);
        monsterMap.put(newMonster.getMonsterName(), newMonster);
    }

    private void addNewMonsterInfo() {
        Monster monster = input.inputMonsterInfo();
        if (monsterMap.containsKey(monster.getMonsterName())) {
            System.out.println(THE_MONSTER_IS_EXIST);
            return;
        }
        monsterMap.put(monster.getMonsterName(), monster);
    }

    private void deleteMonsterInfo() {
        if (checkMonsterMap()) return;
        String monsterName = input.inputMonsterName();
        if (checkMonsterNotExist(monsterName)) return;
        if (input.checkDeleteMonster()) return;
        monsterMap.remove(monsterName);
    }

    private boolean checkMonsterNotExist(String monsterName) {
        boolean monsterExist = monsterMap.containsKey(monsterName);
        if (!monsterExist) {
            System.out.printf(MONSTER_NOT_EXISTS.toString(), monsterName);
        }
        return !monsterExist;
    }

    private void close() {
        try {
            monsterFileWriter.commit(monsterMap);
            monsterFileReader.close();
            monsterFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
