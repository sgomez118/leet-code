package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IsSubsequenceTest {
    
    @Test
    public void isSubsequence_FromExample1_ShouldReturnTrue() {
        // Arrange
        String s = "abc";
        String t = "ahbgdc";
        boolean expect = true;

        // Act
        boolean actual = new IsSubsequence().isSubsequence(s, t);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isSubsequence_FromExample2_ShouldReturnFalse() {
        // Arrange
        String s = "axc";
        String t = "ahbgdc";
        boolean expect = false;

        // Act
        boolean actual = new IsSubsequence().isSubsequence(s, t);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isSubsequence_FromExample3_ShouldReturnTrue() {
         // Arrange
        String s = "ana";
        String t = "banana";
        boolean expect = true;

        // Act
        boolean actual = new IsSubsequence().isSubsequence(s, t);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isSubsequence_EmptySString_ShouldReturnTrue() {
         // Arrange
        String s = "";
        String t = "ahbgdc";
        boolean expect = true;

        // Act
        boolean actual = new IsSubsequence().isSubsequence(s, t);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isSubsequence_SingleChar_ShouldReturnFalse() {
         // Arrange
        String s = "b";
        String t = "c";
        boolean expect = false;

        // Act
        boolean actual = new IsSubsequence().isSubsequence(s, t);

        // Assert
        assertEquals(expect, actual);
    }
}
