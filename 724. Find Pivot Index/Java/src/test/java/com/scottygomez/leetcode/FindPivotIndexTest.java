package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindPivotIndexTest {
    
    @Test
    public void pivotIndex_FromExample1_ShouldReturn3() {
        // Arrange
        int[] input = new int[]{1,7,3,6,5,6};
        int expect = 3;

        // Act
        int actual = new FindPivotIndex().pivotIndexOptimized(input);

        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void pivotIndex_FromExample2_ShouldReturnNegative1() {
        // Arrange
        int[] input = new int[]{1,2,3};
        int expect = -1;

        // Act
        int actual = new FindPivotIndex().pivotIndex(input);
        
        // Assert
        assertEquals(expect, actual);
    }

    @Test
    public void pivotIndex_FromExample3_ShouldReturn0() {
         // Arrange
         int[] input = new int[]{2,1,-1};
         int expect = 0;
 
         // Act
         int actual = new FindPivotIndex().pivotIndex(input);
         
         // Assert
         assertEquals(expect, actual);
    }
}
