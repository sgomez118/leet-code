package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class RunningSumOf1DArrayTest {
    
    @Test
    public void runningSum_FromExample1_ShouldReturn1_3_6_10() {
        // Arrange
        int[] input = new int[]{1,2,3,4};
        int[] expect = new int[]{1,3,6,10};

        // Act
        int[] actual = new RunningSumOf1DArray().runningSum(input);

        // Assert
        assertArrayEquals(expect, actual);
    }

    @Test
    public void runningSum_FromExample2_ShouldReturn1_2_3_4_5() {
        // Arrange
        int[] input = new int[]{1,1,1,1,1};
        int[] expect = new int[]{1,2,3,4,5};

        // Act
        int[] actual = new RunningSumOf1DArray().runningSum(input);
        
        // Assert
        assertArrayEquals(expect, actual);
    }

    @Test
    public void runningSum_FromExample3_ShouldReturn3_4_6_16_17() {
         // Arrange
         int[] input = new int[]{3,1,2,10,1};
         int[] expect = new int[]{3,4,6,16,17};
 
         // Act
         int[] actual = new RunningSumOf1DArray().runningSum(input);
         
         // Assert
         assertArrayEquals(expect, actual);
    }
}
