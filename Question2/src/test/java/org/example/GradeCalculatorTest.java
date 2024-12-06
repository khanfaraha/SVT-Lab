package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "85, B",
            "75, C",
            "65, D",
            "55, F"
    })
    void testGetGrade_ValidScores(int score, String expectedGrade) {
        assertEquals(expectedGrade, GradeCalculator.getGrade(score),
                "Grade should match the expected value");
    }

    @Test
    void testGetGrade_InvalidScores() {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(-1),
                "Should throw an exception for score below 0");
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(101),
                "Should throw an exception for score above 100");
    }
}
