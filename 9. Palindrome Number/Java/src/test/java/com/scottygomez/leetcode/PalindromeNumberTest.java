package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
}
