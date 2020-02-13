package dev.idion.monsterrace.util.datastructure;

import org.junit.jupiter.api.Test;

import static dev.idion.monsterrace.StringConstants.THE_NUMBER_MUST_BE_POSITIVE_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveIntegerTest {
    @Test
    void testGetPositiveInt() {
        String input = "3";
        PositiveInteger positiveInteger = new PositiveInteger(input);
        assertThat(positiveInteger.getPositiveInt()).isEqualTo(3);
    }

    @Test
    void testThrowWhenNegativeInput() {
        String input = "-1";
        assertThatThrownBy(() -> {
            new PositiveInteger(input);
        }).isInstanceOf(NumberFormatException.class)
          .hasMessageContaining(THE_NUMBER_MUST_BE_POSITIVE_VALUE.toString());
    }

    @Test
    void testThrowWhenZeroInput() {
        String input = "0";
        assertThatThrownBy(() -> {
            new PositiveInteger(input);
        }).isInstanceOf(NumberFormatException.class)
          .hasMessageContaining(THE_NUMBER_MUST_BE_POSITIVE_VALUE.toString());
    }

    @Test
    void testThrowWhenWrongTypeInput() {
        String input = "asdfasdf";
        assertThatThrownBy(() -> {
            new PositiveInteger(input);
        }).isInstanceOf(NumberFormatException.class)
          .hasMessageContaining("For input string: \"" + input + "\"");
    }
}
