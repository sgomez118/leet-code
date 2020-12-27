package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringToIntegerAtoiTest {
    
    @Test
    public void myAtoi_WhenStringIs42_ShouldReturnInteger42() {
        // Arrange
        String str = "42";
        int expected = 42;

        // Act
        int actual = new StringToIntegerAtoi().myAtoi(str);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void myAtoi_WhenStringContainsLeadingSpaceNegative42_ShouldReturnIntegerNegative42() {
        // Arrange
        String str = "   -42";
        int expected = -42;

        // Act
        int actual = new StringToIntegerAtoi().myAtoi(str);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void myAtoi_WhenStringContainsWordsAfterNumber4193_ShouldReturnInteger4193() {
        // Arrange
        String str = "4193 with words";
        int expected = 4193;

        // Act
        int actual = new StringToIntegerAtoi().myAtoi(str);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void myAtoi_WhenStringContainsWordsBeforeNumber987_ShouldReturnInteger0() {
        // Arrange
        String str = "words and 987";
        int expected = 0;

        // Act
        int actual = new StringToIntegerAtoi().myAtoi(str);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void myAtoi_WhenStringIsLargerThan32Bits_ShouldReturnIntegerMinimumInteger() {
        // Arrange
        String str = "-91283472332";
        int expected = -2 << 30;

        // Act
        int actual = new StringToIntegerAtoi().myAtoi(str);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void myAtoi_WhenStringIsLargerThanPositive32Bits_ShouldReturnMaxInteger() {
        // Arrange
        String str = "21474836460";
        int expected = (2 << 30) - 1;

        // Act
        int actual = new StringToIntegerAtoi().myAtoi(str);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void myAtoi_WhenStringContainsPlusInMiddle_ShouldReturnFirstSet() {
        // Arrange
        String str = "10+15";
        int expected = 10;

        // Act
        int actual = new StringToIntegerAtoi().myAtoi(str);

        // Assert
        assertEquals(expected, actual);
    }
}
