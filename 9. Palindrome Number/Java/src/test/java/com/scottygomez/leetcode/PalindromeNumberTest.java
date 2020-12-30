package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeNumberTest {
    
    @Test
    public void isPalindrome_WhenIntegerIsPalindrome_ShouldReturnTrue() {
        // Arrange
        int x = 121;
        boolean expected = true;

        // Act
        boolean actual = new PalindromeNumber().isPalindrome(x);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isPalindrome_WhenIntegerIsNegativePalindrome_ShouldReturnFalse() {
        // Arrange
        int x = -121;
        boolean expected = false;

        // Act
        boolean actual = new PalindromeNumber().isPalindrome(x);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isPalindrome_WhenIntegerIsNotPalindrome_ShouldReturnFalse() {
        // Arrange
        int x = 10;
        boolean expected = false;

        // Act
        boolean actual = new PalindromeNumber().isPalindrome(x);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isPalindrome_WhenIntegerIsAnotherNegativePalindrome_ShouldReturnFalse() {
        // Arrange
        int x = -101;
        boolean expected = false;

        // Act
        boolean actual = new PalindromeNumber().isPalindrome(x);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isPalindrome_WhenIntegerIsVeryLargePalindrome_ShouldReturnTrue() {
        // Arrange
        int x = 2147447412;
        boolean expected = true;

        // Act
        boolean actual = new PalindromeNumber().isPalindrome(x);

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void isPalindrome_WhenIntegerIsSingleDigit_ShouldReturnTrue(int x) {
        // Arrange
        boolean expected = true;

        // Act
        boolean actual = new PalindromeNumber().isPalindrome(x);

        // Assert
        assertEquals(expected, actual);
    }
}
