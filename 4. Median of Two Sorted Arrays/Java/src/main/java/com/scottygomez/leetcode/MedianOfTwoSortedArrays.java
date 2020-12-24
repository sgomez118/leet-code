package com.scottygomez.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * MedianOfTwoSortedArrays
 */
public class MedianOfTwoSortedArrays {
    private static final int MAX_SIZE = 1048576;

    public static void main(String[] args) {
        int[] array1 = { 2 };
        int[] array2 = { 1, 3 };
        System.out.println(findMedianSortedArrays(array1, array2)); 
        System.out.println(getMedian(inOrderInsertion(array1, array2)));

        int[] array3 = { 2, 4 };
        int[] array4 = { 3, 5 };
        System.out.println(findMedianSortedArrays(array3, array4));
        System.out.println(getMedian(inOrderInsertion(array3, array4)));

        int[] array5 = { 1, 5 };
        int[] array6 = { 3, 4 };
        System.out.println(findMedianSortedArrays(array5, array6));
        System.out.println(getMedian(inOrderInsertion(array5, array6)));

        int[] array7 = { 1, 2 };
        int[] array8 = { 3, 4 };
        System.out.println(findMedianSortedArrays(array7, array8));
        System.out.println(getMedian(inOrderInsertion(array7, array8)));

        int[] array9 = { 4 };
        int[] array10 = { 3 };
        System.out.println(findMedianSortedArrays(array9, array10));
        System.out.println(getMedian(inOrderInsertion(array9, array10)));

        Random randomSize = new Random();
        for (int index = 0; index < Math.abs(randomSize.nextInt(10)); index++) {
            int[] randomArray1 = generateArray(Math.abs(randomSize.nextInt(MAX_SIZE)));
            int[] randomArray2 = generateArray(Math.abs(randomSize.nextInt(MAX_SIZE)));
            //System.out.print("Random Array 1: ");
            //printArray(randomArray1);
            System.out.println();
            System.out.println("Random Array 1 Size: " + randomArray1.length);

            //System.out.print("Random Array 2: ");
            //printArray(randomArray2);
            System.out.println();
            System.out.println("Random Array 2 Size: " + randomArray2.length);

            long start = System.currentTimeMillis();
            System.out.println(getMedian(inOrderInsertion(randomArray1, randomArray2)));
            long end = System.currentTimeMillis() - start;
            System.out.println("Linear Completion time: " + end);

            start = System.currentTimeMillis();
            System.out.println(findMedianSortedArrays(randomArray1, randomArray2));
            end = System.currentTimeMillis() - start;
            System.out.println("Binary Completion time: " + end);
            System.out.println();
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Need to make sure we are using the smaller array as the pivoting point
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        double median = Double.NaN;
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int left = 0;
        int right = nums1Length;
        while (left <= right) {
            // Get the pivot point of both arrays
            int pivotPointNums1 = (right + left) / 2;
            int pivotPointNums2 = (nums1Length + nums2Length + 1) / 2 - pivotPointNums1;

            // If arrays are "disjoint" then use integer min/max values to represent
            // infinity values on either side of the pivot
            // Otherwise get max/min values based on the pivot point calculated from above
            int maximumLeftNums1 = (pivotPointNums1 == 0) ? Integer.MIN_VALUE : nums1[pivotPointNums1 - 1];
            int minimumRightNums1 = (pivotPointNums1 == nums1Length) ? Integer.MAX_VALUE : nums1[pivotPointNums1];

            int maximumLeftNums2 = (pivotPointNums2 == 0) ? Integer.MIN_VALUE : nums2[pivotPointNums2 - 1];
            int minimumRightNums2 = (pivotPointNums2 == nums2Length) ? Integer.MAX_VALUE : nums2[pivotPointNums2];

            if (maximumLeftNums1 <= minimumRightNums2 && maximumLeftNums2 <= minimumRightNums1) {
                // This means the new array is even and must take the average of 2 values,
                // otherwise the midpoint
                if ((nums1Length + nums2Length) % 2 == 0) {
                    median = (Math.max(maximumLeftNums1, maximumLeftNums2)
                            + Math.min(minimumRightNums1, minimumRightNums2)) / 2.0;
                } else {
                    median = Math.max(maximumLeftNums1, maximumLeftNums2);
                }
                break;
            } else if (maximumLeftNums1 > minimumRightNums2) {
                // We're too far right, need to move left
                right = pivotPointNums1 - 1;
            } else {
                // We're too far left, need to move right
                left = pivotPointNums1 + 1;
            }
        }
        return median;
    }

    private static int[] inOrderInsertion(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        int index = 0, array1Index = 0, array2Index = 0;

        // insert in order
        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] <= array2[array2Index]) {
                array[index++] = array1[array1Index++];
            } else {
                array[index++] = array2[array2Index++];
            }
        }

        // Copy any remaining values at the end of the array
        while (array1Index < array1.length) {
            array[index++] = array1[array1Index++];
        }

        while (array2Index < array2.length) {
            array[index++] = array2[array2Index++];
        }

        return array;
    }

    private static double getMedian(int[] array) {
        double median = Double.NaN;
        if (array != null && array.length > 0) {
            int midPoint = (array.length - 1) / 2;
            if (array.length % 2 == 0) {
                median = ((double) array[midPoint] + array[midPoint + 1]) / 2;
            } else {
                median = array[midPoint];
            }
        }
        return median;
    }

    private static int[] generateArray(int size) {
        int[] array = null;
        Random random = new Random();
        if (size > 0) {
            array = new int[size];
            for (int index = 0; index < size; index++) {
                array[index] = random.nextInt();
            }
            Arrays.sort(array);
        }
        return array;
    }

    // private static void printArray(int array[]) {
    //     for (int i = 0; i < array.length; ++i)
    //         System.out.print(array[i] + " ");
    //     System.out.println();
    // }
}