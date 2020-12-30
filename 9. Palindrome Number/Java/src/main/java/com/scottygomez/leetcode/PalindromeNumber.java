package com.scottygomez.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        boolean isPalindrome = false;

        // Based on the definition negative numbers aren't considered palindromes
        if (x < 0) {
            return isPalindrome;
        }

        // Use the logarithms to find out the "length" of the integer
        int length = (int) (Math.log10(x) + 1);
        int[] integerArray = new int[length/2];

        // "Push" half the digits into the "stack"
        for(int i = 0; i < integerArray.length; i++) {
            integerArray[i] = x % 10;
            x /= 10;
        }

        // If we're not even discard the middle value
        x = length % 2 == 0 ? x : x / 10;

        // "Pop" digits from the "stack"
        for(int i = integerArray.length - 1; i >= 0; i--) {
            int digit = x % 10;
            x /= 10;
            if (integerArray[i] == digit) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}
