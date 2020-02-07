package dev.idion;

public enum StringConstants {
    PROMPT("> "),
    GAME_NAME("<심심한 몬스터 경주>"),
    INPUT_MESSAGE("를 입력해주세요."),
    MONSTER_COUNT_STRING("몬스터의 수"),
    ATTEMPT_COUNT_STRING("시도할 횟수"),
    INPUT_MONSTER_NAME_AND_TYPE("경주할 몬스터의 이름과 타입을 입력해주세요. ','로 구분합니다."),
    CORRECT_INPUT_STRING("%s를 정확히 입력해주세요.%n%s"),
    THE_NUMBER_MUST_BE_POSITIVE_VALUE("숫자는 양수여야 합니다."),
    ERROR_MESSAGE("게임 실행 도중 오류가 발생했습니다."),
    TYPE_NOT_EXIST("입력하신 타입은 존재하지 않는 타입입니다. 다시 입력해주세요."),
    RESULT_MESSAGE("<실행 결과>"),
    WINNER_MESSAGE("축하합니다! %s가 몬스터 레이스에서 우승했습니다!%n"),
    GAME_EXIT_MESSAGE("게임을 종료합니다.");

    private String message;

    StringConstants(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
