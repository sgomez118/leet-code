package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IsomorphicStringsTest {
    
    @Test
    public void isIsomorphic_FromExample1_ShouldReturnTrue() {
        // Arrange
        String inputS = "egg";
        String inputT = "add";
        boolean expect = true;

        // Act
        boolean actual = new IsomorphicStrings().isIsomorphic(inputS, inputT);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isIsomorphic_FromExample2_ShouldReturnFalse() {
        // Arrange
        String inputS = "foo";
        String inputT = "bar";
        boolean expect = false;

        // Act
        boolean actual = new IsomorphicStrings().isIsomorphic(inputS, inputT);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isIsomorphic_FromExample3_ShouldReturnTrue() {
         // Arrange
        String inputS = "paper";
        String inputT = "title";
        boolean expect = true;

        // Act
        boolean actual = new IsomorphicStrings().isIsomorphic(inputS, inputT);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isIsomorphic_Input_badc_ShouldReturnFalse() {
         // Arrange
        String inputS = "badc";
        String inputT = "baba";
        boolean expect = false;

        // Act
        boolean actual = new IsomorphicStrings().isIsomorphic(inputS, inputT);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void isIsomorphic_Input_bbbaaaba_ShouldReturnFalse() {
         // Arrange
        String inputS = "bbbaaaba";
        String inputT = "aaabbbba";
        boolean expect = false;

        // Act
        boolean actual = new IsomorphicStrings().isIsomorphic(inputS, inputT);

        // Assert
        assertEquals(expect, actual);
    }
}
