package dev.idion;

public class Monster {
    private int moveCount;
    private String monsterName;
    private MonsterType monsterType;

    public Monster(String monsterName, MonsterType monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;
    }

    public void moveMonster() {
        this.moveCount++;
    }

    @Override
    public String toString() {
        StringBuilder monsterDistanceBuilder = new StringBuilder();
        monsterDistanceBuilder.append(monsterName).append(" [").append(monsterType).append("] : ");
        for (int i = 0; i < moveCount; i++) {
            monsterDistanceBuilder.append("-");
        }
        return monsterDistanceBuilder.toString();
    }
}
