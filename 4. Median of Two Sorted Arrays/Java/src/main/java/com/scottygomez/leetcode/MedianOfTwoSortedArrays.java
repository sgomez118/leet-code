package com.scottygomez.leetcode;

/**
 * MedianOfTwoSortedArrays
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] array1 = { 2 };
        int[] array2 = { 1, 3 };
        System.out.println(findMedianSortedArrays(array1, array2));

        int[] array3 = { 2, 4 };
        int[] array4 = { 3, 5 };
        System.out.println(findMedianSortedArrays(array3, array4));

        int[] array5 = { 1, 5 };
        int[] array6 = { 3, 4 };
        System.out.println(findMedianSortedArrays(array5, array6));

        int[] array7 = { 1, 2 };
        int[] array8 = { 3, 4 };
        System.out.println(findMedianSortedArrays(array7, array8));

        int[] array9 = { 4 };
        int[] array10 = { 3 };
        System.out.println(findMedianSortedArrays(array9, array10));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Need to make sure we are using the smaller array as the pivoting point
        if (nums1.length > nums2.length) {
            findMedianSortedArrays(nums2, nums1);
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

            // If arrays are "disjoint" then use integer min/max values to represent infinity values on either side of the pivot
            // Otherwise get max/min values based on the pivot point calculated from above
            int maximumLeftNums1 = (pivotPointNums1 == 0) ? Integer.MIN_VALUE : nums1[pivotPointNums1 - 1];
            int minimumRightNums1 = (pivotPointNums1 == nums1Length) ? Integer.MAX_VALUE : nums1[pivotPointNums1];

            int maximumLeftNums2 = (pivotPointNums2 == 0) ? Integer.MIN_VALUE : nums2[pivotPointNums2 - 1];
            int minimumRightNums2 = (pivotPointNums2 == nums2Length) ? Integer.MAX_VALUE : nums2[pivotPointNums2];

            if (maximumLeftNums1 <= minimumRightNums2 && maximumLeftNums2 <= minimumRightNums1) {
                // This means the new array is even and must take the average of 2 values, otherwise the midoint
                if((nums1Length + nums2Length) % 2 == 0) {
                    median = (Math.max(maximumLeftNums1, maximumLeftNums2) + Math.min(minimumRightNums1, minimumRightNums2))/2.0;
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
        
    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}