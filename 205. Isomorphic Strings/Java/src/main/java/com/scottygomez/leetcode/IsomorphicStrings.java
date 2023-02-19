package com.scottygomez.leetcode;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == t) {
            return true;
        }

        char[] sMapToT = new char[257];
        char[] tMapToS = new char[257];

        for (int i = 0; i < s.length(); i++) {
            if (sMapToT[s.charAt(i)] == '\u0000') {
                sMapToT[s.charAt(i)] = t.charAt(i);
            }
            if (tMapToS[t.charAt(i)] == '\u0000') {
                tMapToS[t.charAt(i)] = s.charAt(i);
            }
            if (sMapToT[s.charAt(i)] != t.charAt(i) || tMapToS[t.charAt(i)] != s.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
