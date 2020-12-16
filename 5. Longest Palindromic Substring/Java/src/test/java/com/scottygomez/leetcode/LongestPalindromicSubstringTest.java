package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class LongestPalindromicSubstringTest {
    
    @Test
    public void isPalindrome_SingleCharacter_ShouldReturnTrue() {
        // Arrange
        String word = "a";

        // Act
        boolean isPalindrome = LongestPalindromicSubstring.isPalindrome(word);

        // Assert
        assertTrue(isPalindrome);
    }

    @Test
    public void isPalindrome_WhenStringIsPalindrome_ShouldReturnTrue() {
        // Arrange
        // Act
        // Assert
    }

    @Test
    public void isPalindrome_WhenStringIsNotPalindrome_ShouldReturnFalse() {
        // Arrange
        // Act
        // Assert
    }
}
