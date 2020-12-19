package com.scottygomez.leetcode;

/**
 * Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("babad"));
    }

    public static String longestPalindromicSubstring(String word) {
        String longestPalindrome = null;

        for (int i = 0; i < word.length(); i++) {
            int left = 0;
            int right = word.length() - i;
            
            String palindrome = word.substring(left, right);
            while (right < word.length() && !isPalindrome(palindrome)) {
                left += 1;
                right += 1;
                palindrome = word.substring(left, right);
            }

            if (isPalindrome(palindrome)) {
                longestPalindrome = palindrome;
                break;
            }
        }

        return longestPalindrome;
    }

    public static boolean isPalindrome(String word) {
        boolean isPalindrome = false;
        
        // Make sure the word is not empty
        if (word != null && !word.isBlank()) {
            int left = 0;
            int right = word.length() - 1;
            int middle = word.length() / 2;

            while (word.charAt(left) == word.charAt(right)) {
                // exit
                if (left == middle) {
                    isPalindrome = true;
                    break;
                }

                left += 1;
                right -= 1;
            }
        }
        return isPalindrome;
    }
}
