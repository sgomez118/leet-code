package com.scottygomez.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == t) {
            return true;
        }

        Map<Character, Character> sMapToT = new HashMap<>();
        Map<Character, Character> tMapToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!sMapToT.containsKey(s.charAt(i))) {
                sMapToT.put(s.charAt(i), t.charAt(i));
            }
            if (!tMapToS.containsKey(t.charAt(i))) {
                tMapToS.put(t.charAt(i), s.charAt(i));
            }
            if (sMapToT.get(s.charAt(i)) != t.charAt(i) || tMapToS.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
