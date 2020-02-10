package dev.idion.monsterrace;

public enum MainMenu {
    MONSTER_INFO("몬스터 정보", 1),
    GAME_START("게임 시작", 2);

    private final String message;
    private final int menuNumber;

    MainMenu(String message, int menuNumber) {
        this.message = message;
        this.menuNumber = menuNumber;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", menuNumber, message);
    }
}
