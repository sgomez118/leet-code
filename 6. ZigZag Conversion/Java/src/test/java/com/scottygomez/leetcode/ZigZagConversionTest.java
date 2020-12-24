package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ZigZagConversionTest {
    
    @Test
    public void conversion_WhenStringIsA_ShouldReturnA() {
        // Arrange
        String word = "A";
        String expectedConversionString = "A";
        int numberOfRows = 1;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);

        // Assert
        assertEquals(expectedConversionString, convertedString);
    }
    @Test
    public void conversion_WhenRowsIsOne_ShouldReturnSameString() {
        // Arrange
        String word = "PAYPALISHIRING";
        String expectedConversionString = "PAYPALISHIRING";
        int numberOfRows = 1;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);

        // Assert
        assertEquals(expectedConversionString, convertedString);
    }

    @Test
    public void conversion_WhenNumberOfRowsIs2_ShouldReturn2RowPattern() {
        // Arrange
        String word = "PAYPALISHIRING";
        String expectedConversionString = "PYAIHRNAPLSIIG";
        int numberOfRows = 2;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);
        
        // Assert
        assertEquals(expectedConversionString, convertedString);
    }

    @Test
    public void conversion_WhenNumberOfRowsIs3_ShouldReturn3RowPattern() {
        // Arrange
        String word = "PAYPALISHIRING";
        String expectedConversionString = "PAHNAPLSIIGYIR";
        int numberOfRows = 3;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);
        
        // Assert
        assertEquals(expectedConversionString, convertedString);
    }

    @Test
    public void conversion_WhenNumberOfRowsIs4_ShouldReturn4RowPattern() {
        // Arrange
        String word = "PAYPALISHIRING";
        String expectedConversionString = "PINALSIGYAHRPI";
        int numberOfRows = 4;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);
        
        // Assert
        assertEquals(expectedConversionString, convertedString);
    }

    @Test
    public void conversion_WhenNumberOfRowsIs5_ShouldReturn5RowPattern() {
        // Arrange
        String word = "PAYPALISHIRING";
        String expectedConversionString = "PHASIYIRPLIGAN";
        int numberOfRows = 5;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);
        
        // Assert
        assertEquals(expectedConversionString, convertedString);
    }

    @Test
    public void conversion_WhenNumberOfRowsIs6_ShouldReturn6RowPattern() {
        // Arrange
        String word = "PAYPALISHIRING";
        String expectedConversionString = "PRAIIYHNPSGAIL";
        int numberOfRows = 6;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);
        
        // Assert
        assertEquals(expectedConversionString, convertedString);
    }

    @Test
    public void conversion_WhenHardPillToSwallow_ShouldReturnConversion4() {
        // Arrange
        String word = "HardPilltoSwallow";
        String expectedConversionString = "HlaailwlrPtSlwdoo";
        int numberOfRows = 4;

        // Act
        String convertedString = ZigZagConversion.convert(word, numberOfRows);
        
        // Assert
        assertEquals(expectedConversionString, convertedString);
    }
}
