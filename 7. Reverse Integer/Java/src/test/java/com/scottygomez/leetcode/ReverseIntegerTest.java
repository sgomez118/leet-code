package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReverseIntegerTest {
    
    @Test
    public void reverse_WhenIntIs123_ShouldReturn321() {
        // Arrange
        int x = 123;
        int expected = 321;
        
        // Act
        int actual = new ReverseInteger().reverse(x);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void reverse_WhenIntIsNegative123_ShouldReturnNegative321() {
        // Arrange
        int x = -123;
        int expected = -321;
        
        // Act
        int actual = new ReverseInteger().reverse(x);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void reverse_WhenIntIs120_ShouldReturn21() {
        // Arrange
        int x = 120;
        int expected = 21;
        
        // Act
        int actual = new ReverseInteger().reverse(x);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void reverse_WhenIntIs0_ShouldReturn0() {
        // Arrange
        int x = 0;
        int expected = 0;
        
        // Act
        int actual = new ReverseInteger().reverse(x);
        
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void reverse_WhenReversedIntIsLargerThan32Bits_ShouldReturn0() {
        // Arrange
        int x = 1534236469;
        int expected = 0;

        // Act
        int actual = new ReverseInteger().reverse(x);

        // Assert
        assertEquals(expected, actual);
    }
}
