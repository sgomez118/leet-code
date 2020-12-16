package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"civic", "kayak", "level", "madam", "mom", "noon", "racecar", "radar", "redder", "refer", "repaper", "rotator", "rotor", "sagas", "solos", "stats","tenet", "wow"})
    public void isPalindrome_WhenStringIsPalindrome_ShouldReturnTrue(String word) {
        // Arrange
        boolean isPalindrome = false;

        // Act
        isPalindrome = LongestPalindromicSubstring.isPalindrome(word);

        // Assert
        assertTrue(isPalindrome);
    }

    @ParameterizedTest
    @ValueSource(strings = {"reflection", "stable", "sphere", "mood", "fuel", "park", "image", "or", "you", "trust", "kindgom"})
    public void isPalindrome_WhenStringIsNotPalindrome_ShouldReturnFalse(String word) {
        // Arrange
        boolean isPalindrome = false;

        // Act
        isPalindrome = LongestPalindromicSubstring.isPalindrome(word);
        
        // Assert
        assertTrue(!isPalindrome);
    }
}
