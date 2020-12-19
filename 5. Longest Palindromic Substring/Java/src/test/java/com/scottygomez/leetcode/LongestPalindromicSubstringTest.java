package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @ValueSource(strings = {"reflection", "stable", "sphere", "mood", "fuel", "park", "image", "or", "you", "trust", "kingdom"})
    public void isPalindrome_WhenStringIsNotPalindrome_ShouldReturnFalse(String word) {
        // Arrange
        boolean isPalindrome = false;

        // Act
        isPalindrome = LongestPalindromicSubstring.isPalindrome(word);
        
        // Assert
        assertTrue(!isPalindrome);
    }

    @ParameterizedTest
    @ValueSource(strings = {"civic", "kayak", "level", "madam", "mom", "noon", "racecar", "radar", "redder", "refer", "repaper", "rotator", "rotor", "sagas", "solos", "stats","tenet", "wow"})
    public void longestPalindromicSubstring_WhenStringIsFullPalindrome_ShouldMatchWholeString(String word) {
        // Arrange
        int wordLength = word.length();

        // Act
        String palindrome = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(wordLength, palindrome.length());
        assertEquals(word, palindrome);
    }

    @ParameterizedTest
    @ValueSource(strings = {"civica", "kayaka", "levela", "madama", "moma", "noona", "racecara", "radara", "reddera", "refera", "repapera", "rotatora", "rotora", "sagasa", "solosa", "statsa","teneta", "wowa"})
    public void longestPalindromicSubstring_WhenStringHasPalindromeInFront_ShouldMatchPalindromeUpToLastCharacter(String word) {
        // Arrange
        String palindromeToMatch = word.substring(0, word.length() - 1);

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @ParameterizedTest
    @ValueSource(strings = {"acivic", "akayak", "alevel", "amadam", "amom", "anoon", "aracecar", "aradar", "aredder", "arefer", "arepaper", "arotator", "arotor", "asagas", "asolos", "astats","atenet", "awow"})
    public void longestPalindromicSubstring_WhenStringHasPalindromeInBack_ShouldMatchPalindromeAfter1stCharacter(String word) {
        // Arrange
        String palindromeToMatch = word.substring(1);

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasBABAD_ShouldReturnBAB() {
        // Arrange
        String word = "babad";
        String palindromeToMatch = "bab";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasCBBD_ShouldReturnBB() {
        // Arrange
        String word = "cbbd";
        String palindromeToMatch = "bb";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasA_ShouldReturnA() {
        // Arrange
        String word = "a";
        String palindromeToMatch = "a";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasAC_ShouldReturnA() {
        // Arrange
        String word = "ac";
        String palindromeToMatch = "a";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasABB_ShouldReturnBB() {
        // Arrange
        String word = "abb";
        String palindromeToMatch = "bb";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasCABB_ShouldReturnBB() {
        // Arrange
        String word = "cabb";
        String palindromeToMatch = "bb";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasEABCB_ShouldReturnBCB() {
        // Arrange
        String word = "eabcb";
        String palindromeToMatch = "bcb";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }

    @Test
    public void longestPalindromicSubstring_WhenStringHasMultiplePalindromes_ShouldReturnLongestPalindrome() {
        // Arrange
        String word = "aaabbbbccccc";
        String palindromeToMatch = "ccccc";

        // Act
        String longestPalindromicSubstring = LongestPalindromicSubstring.longestPalindromicSubstring(word);

        // Assert
        assertEquals(palindromeToMatch, longestPalindromicSubstring);
    }
}
