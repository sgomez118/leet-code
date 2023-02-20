package com.scottygomez.leetcode;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isBlank()) {
            return true;
        }
        if (t.isBlank()) {
            return false;
        }
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }
        return false;
    }
}
