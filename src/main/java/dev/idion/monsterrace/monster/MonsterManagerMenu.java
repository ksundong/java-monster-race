package dev.idion.monsterrace.monster;

public enum MonsterManagerMenu {
    SHOW_ALL_MONSTERS_INFO("전체 몬스터 정보 보기", 1),
    MODIFY_MONSTER_INFO("몬스터 정보 수정", 2),
    ADD_NEW_MONSTER("새로운 몬스터 정보 입력", 3),
    DELETE_MONSTER_INFO("몬스터 정보 삭제", 4),
    GO_TO_PREVIOUS_MENU("이전 메뉴로", 5);

    private final String message;
    private final int menuNumber;

    MonsterManagerMenu(String message, int menuNumber) {
        this.message = message;
        this.menuNumber = menuNumber;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", menuNumber, message);
    }
}
