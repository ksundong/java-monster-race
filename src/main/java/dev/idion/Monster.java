package dev.idion;

public class Monster {
    private int moveCount;
    private String monsterName;
    private MonsterType monsterType;

    public void plusMoveCount() {
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
