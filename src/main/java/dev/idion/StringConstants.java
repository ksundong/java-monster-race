package dev.idion;

public enum StringConstants {
    PROMPT("> "),
    GAME_NAME("<심심한 몬스터 경주>"),
    INPUT_MESSAGE("를 입력해주세요."),
    MONSTER_COUNT_STRING("몬스터의 수"),
    ATTEMPT_COUNT_STRING("시도할 횟수"),
    CORRECT_INPUT_STRING("%s를 정확히 입력해주세요.%n%s"),
    THE_NUMBER_MUST_BE_POSITIVE_VALUE("숫자는 양수여야 합니다."),
    ERROR_MESSAGE("게임 실행 도중 오류가 발생했습니다."),
    RESULT_MESSAGE("<실행 결과>"),
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
