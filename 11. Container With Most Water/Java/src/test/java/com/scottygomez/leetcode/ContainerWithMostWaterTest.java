package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ContainerWithMostWaterTest {
    @Test
    public void maxArea_FromExample1_ShouldReturn49() {
        // Arrange
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int expected = 49;

        // Act
        int actual = new ContainerWithMostWater().maxArea(height);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void maxArea_FromExample2_ShouldReturn1() {
        // Arrange
        int[] height = { 1, 1 };
        int expected = 1;

        // Act
        int actual = new ContainerWithMostWater().maxArea(height);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void maxArea_FromExample3_ShouldReturn16() {
        // Arrange
        int[] height = { 4, 3, 2, 1, 4 };
        int expected = 16;

        // Act
        int actual = new ContainerWithMostWater().maxArea(height);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void maxArea_FromExample4_ShouldReturn2() {
        // Arrange
        int[] height = { 1, 2, 1 };
        int expected = 2;

        // Act
        int actual = new ContainerWithMostWater().maxArea(height);

        // Assert
        assertEquals(expected, actual);
    }
}
