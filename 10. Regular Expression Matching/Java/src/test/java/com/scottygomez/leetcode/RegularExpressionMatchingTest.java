package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegularExpressionMatchingTest {
    @Test
    public void isMatch_WhenPatternIsAAndStringIsAA_ShouldReturnFalse() {
        // Arrange
        String s = "aa";
        String p = "a";
        boolean expected = false;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenPatternIsAStarAndStringIsAA_ShouldReturnTrue() {
        // Arrange
        String s = "aa";
        String p = "a*";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenPatternIsPeriodStarAndStringIsAB_ShouldReturnTrue() {
        // Arrange
        String s = "ab";
        String p = ".*";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenPatternIsCStarAStarBAndStringAAB_ShouldReturnTrue() {
        // Arrange
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenPatternIsMISStarISStarPStarPeriodAndStringIsMISSISSIPPI_ShouldReturnFalse() {
        // Arrange
        String s = "mississippi";
        String p = "mi*is*p*i";
        boolean expected = false;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"mississppi", "mississppa", "mississi", "mississ", "missis", "missia", "misis", "miix"})
    public void isMatch_WhenPatternIsMISStarISStarPStarPeriodAndStringMatchesPattern_ShouldReturnTrue(String s) {
        // Arrange
        String p = "mis*is*p*.";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenStringIsEmptyAndPatternIsEmpty_ShouldReturnTrue() {
        // Arrange
        String s = "";
        String p = "";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenStringIsEmptyAndPatternIsNotEmpty_ShouldReturnFalse() {
        // Arrange
        String s = "";
        String p = "a";
        boolean expected = false;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenStringIsNotEmptyAndPatternIsEmpty_ShouldReturnFalse() {
        // Arrange
        String s = "aa";
        String p = "";
        boolean expected = false;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenStringIsLength20AndPatternIsLength30_ShouldReturnTrue() {
        // Arrange
        String s = "bbcccdddeeeedddcccbb";
        String p = "a*bb*ccc*ddd*eeee*ddd*ccc*bb*.";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenStringMatchesPatternAndPatternHasPeriodStarAndMore_ShouldReturnTrue() {
        // Arrange
        String s = "cclurkbccddeeeddccbb";
        String p = ".*a*bb*ccc*ddd*eeee*ddd*ccc*bb";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void isMatch_WhenStringDoesNotMatchePatternAndPatternHasPeriodStarAndMore_ShouldReturnFalse() {
        // Arrange
        String s = "clurkbccddeeeddccbbd";
        String p = ".*a*bb*ccc*ddd*eeee*ddd*ccc*bb";
        boolean expected = true;

        // Act
        boolean actual = new RegularExpressionMatching().isMatch(s, p);

        // Assert
        assertEquals(expected, actual);
    }
}
