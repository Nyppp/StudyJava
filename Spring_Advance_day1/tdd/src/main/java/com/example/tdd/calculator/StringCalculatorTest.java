package com.example.tdd.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환한다")
    void emptyStringReturnsZero() {
        // TODO: 테스트 작성
        // given

        // when

        // then
    }
}
