package com.scottygomez.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // Make sure that there is a minimum of 2 numbers
        if (height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Need to find the minimum of two because slanting water is not allowed
            int min = Math.min(height[left], height[right]);

            int area = min * (right - left);
            
            if (area > maxArea) {
                maxArea = area;
            }

            // Anchor based on tallest
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }


        return maxArea;
    }
}
