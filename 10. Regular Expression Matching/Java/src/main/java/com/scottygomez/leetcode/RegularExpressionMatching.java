package com.scottygomez.leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // Base case
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // When second character is not '*' pattern
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) {
                return false;
            }

            // If the first character of pattern is not ".", the first character of pattern
            // and string should be the same. Then continue to match the remaining part.
            return isMatch(s.substring(1), p.substring(1));

        } else {
            // The second character of pattern is '*'

            int stringIndex = -1;
            while (stringIndex < s.length()
                    && (stringIndex < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(stringIndex))) {

                // If the first character of pattern is "." or first character of pattern == the
                // first index character of string, continue to match the remaining part.
                if (isMatch(s.substring(stringIndex + 1), p.substring(2))) {
                    return true;
                }

                stringIndex++;
            }

            return false;
        }
    }
}