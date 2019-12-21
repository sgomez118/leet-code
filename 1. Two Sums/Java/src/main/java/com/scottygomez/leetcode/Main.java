package com.scotty.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // From the example
        int[] nums = { 2, 7, 11, 15 };
        int _target = 9;
        int[] retVal = twoSums(nums, _target);
        System.out.println("Should equal 0,1 == " + retVal[0] + "," + retVal[1]);

        List<Integer> targets = generateTargets(nums);
        for (int target : targets) {
            int[] sumIndexes = twoSums(nums, target);
            System.out.println(sumIndexes[0] + "," + sumIndexes[1]);
        }
    }

    private static int[] twoSums(int[] numbers, int target) {
        int[] twoSums = new int[2];
        for (int i = 0; i < numbers.length; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                if (numbers[i] + numbers[j] == target) {
                    twoSums[0] = i;
                    twoSums[1] = j;
                    return twoSums;
                }
            }
        }
        return twoSums;
    }

    /**
     * Generates sum targets based on array of numbers
     * 
     * @param numbers the array of numbers
     * @return list of the sum of two numbers
     */
    private static List<Integer> generateTargets(int[] numbers) {
        List<Integer> targets = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                targets.add(numbers[i] + numbers[j]);
            }
        }
        return targets;
    }
}