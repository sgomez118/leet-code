package com.scottygomez.leetcode;

public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        // if empty array return 
        if (nums.length == 0) {
            return nums;
        }

        int[] runningSum = new int[nums.length];
        // first value
        runningSum[0] = nums[0];

        for (int i = 1; i < runningSum.length; i++) {
            runningSum[i] = runningSum[i-1] + nums[i];
        }

        return runningSum;
    }
}
