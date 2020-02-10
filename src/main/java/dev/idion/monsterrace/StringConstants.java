package dev.idion.monsterrace;

import dev.idion.monsterrace.monster.MonsterManagerMenu;
import dev.idion.monsterrace.monster.MonsterType;

import java.util.Arrays;

public enum StringConstants {
    PROMPT("> "),
    GAME_NAME("<심심한 몬스터 경주>"),
    PLEASE_SELECT_MENUS_MAIN("원하는 메뉴를 선택해주세요. " + showMenuRange(MainMenu.values())),
    PLEASE_SELECT_MENUS_MONSTER("원하는 메뉴를 선택해주세요. " + showMenuRange(MonsterManagerMenu.values())),
    MENU_NUMBER("메뉴 번호"),
    THE_NUMBER_IS_NOT_VALID("해당 메뉴 번호는 없는 번호입니다. 다시 입력해주세요."),
    INPUT_MESSAGE("를 입력해주세요."),
    MONSTER_COUNT_STRING("몬스터의 수"),
    ATTEMPT_COUNT_STRING("시도할 횟수"),
    INPUT_MONSTER_NAME_AND_TYPE("경주할 몬스터의 이름과 타입을 입력해주세요. ','로 구분합니다. ex) 디온, 비행"),
    SHOW_MONSTER_TYPES("몬스터의 타입은 다음과 같습니다. " + Arrays.toString(MonsterType.values())),
    CORRECT_INPUT_STRING("%s를 정확히 입력해주세요. 에러메시지: %s%n%s"),
    THE_NUMBER_MUST_BE_POSITIVE_VALUE("숫자는 양수여야 합니다."),
    INPUT_CORRECT_MONSTER_NAME_AND_TYPE("이름과 타입은 ','로 구분되어야 합니다."),
    TYPE_NOT_EXIST("%s는 타입에 맞지않습니다."),
    RESULT_MESSAGE("<실행 결과>"),
    WINNER_MESSAGE("축하합니다! %s이(가) 몬스터 레이스에서 우승했습니다!%n"),
    GAME_EXIT_MESSAGE("게임을 종료합니다.");

    private final String message;

    StringConstants(String message) {
        this.message = message;
    }

    private static String showMenuRange(Object[] array) {
        return "[1 - " + array.length + "]";
    }

    @Override
    public String toString() {
        return this.message;
    }
}
