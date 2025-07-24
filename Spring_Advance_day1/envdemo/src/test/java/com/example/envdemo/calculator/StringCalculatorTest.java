package com.example.envdemo.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환한다")
    void emptyStringReturnsZero() {
        // given
        String input = "";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("쉼표 구분자로 숫자를 더한다")
    void addNumbersWithComma() {
        // given
        String input = "1,2,3";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("콜론 구분자로 숫자를 더한다")
    void addNumbersWithColon() {
        // given
        String input = "1:2:3";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("쉼표와 콜론을 혼용할 수 있다")
    void addNumbersWithMixedDelimiters() {
        // given
        String input = "1,2:3";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정할 수 있다")
    void customDelimiter() {
        // given
        String input ="//;\n1;2;3";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러 글자일 수 있다")
    void multiCharacterCustomDelimiter() {
        // given
        String input = "//[////www//@@#@]\n1////www//@@#@2////www//@@#@3";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력 시 예외가 발생한다")
    void negativeNumberThrowsException() {
        assertThatThrownBy(() -> {
            calculator.add("-1,2:3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("음수가 여러 개일 경우 모두 표시한다")
    void multipleNegativeNumbersInExceptionMessage() {
        assertThatThrownBy(() -> {
            calculator.add("-1,2,-3");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("-1")
                .hasMessageContaining("-3");

    }

    @Test
    @DisplayName("1000을 초과하는 숫자는 무시한다")
    void ignoreNumbersGreaterThan1000() {
        // given
        String input = "2,100545541,6,6555";

        // when
        int result = calculator.add(input);

        // then
        assertThat(result).isEqualTo(8);
    }
}
