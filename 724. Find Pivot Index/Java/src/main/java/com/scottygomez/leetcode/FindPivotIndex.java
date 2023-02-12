package com.scottygomez.leetcode;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // the pivot
            int pivotIndex = i;
            // sum of the left to the pivot
            int sumLeft = 0;
            for (int j = 0; j < pivotIndex; j++) {
                sumLeft += nums[j];
            }

            // sum of the right to the pivot
            int sumRight = 0;
            for (int j = pivotIndex + 1; j < nums.length; j++) {
                sumRight += nums[j];
            }

            if (sumLeft == sumRight) {
                return pivotIndex;
            }
        }
        return -1;
    }

    public int pivotIndexOptimized(int[] nums) {
        /** Not my optimized solution **/
        int[] temp = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                temp[i] = nums[i];
            } else {
                temp[i] = temp[i + 1] + nums[i];
            }
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return left == 0 ? nums.length - 1 : -1;
            }
            int right = temp[i + 1];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }
}
