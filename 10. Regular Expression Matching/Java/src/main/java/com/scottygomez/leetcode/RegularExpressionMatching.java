package com.scottygomez.leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean isMatch = false;

        // If the string and the patter are an exact match, just return
        if (s != null && p != null && !p.contains(".") && !p.contains("*")) {
            return p.equals(s);
        }

        // Need to keep track of any character flag
        boolean isMatchAnyCharacter = false;

        // Need to keep track of many character flag
        boolean isMatch0OrMoreCharacters = false;

        // Set the starting point of the string
        int stringIndex = 0;

        // We want to iterate through the pattern since its going to be the
        // driver to search for repeated characters
        for (int i = 0; i < p.length(); i++) {
            char nextCharacterToMatch = p.charAt(i);

            isMatchAnyCharacter = nextCharacterToMatch == '.';

            if (isNextCharacterStar(i, p)) {
                // Move to next stop character.
                if (i + 2 < p.length()) {
                    i++;
                    
                } else if (isMatchAnyCharacter) {
                    // if '.*' is at the end of the string pattern, gobble up remaining string.
                    isMatch = true;
                    break;
                }

                isMatch0OrMoreCharacters = true;
            }

            // Iterate through string s
            while (stringIndex < s.length()) {
                // Pop until length
                if (isMatchAnyCharacter && isMatch0OrMoreCharacters) {
                    isMatch = true;
                    int pull = p.length() - i - 1;
                    stringIndex = s.length() - pull;

                    // String pattern is longer than our actual 
                    if (stringIndex < 0) {
                        stringIndex = 0;
                    }

                    break;
                }

                // Pop character
                char nextCharacter = s.charAt(stringIndex);

                // Pop 0 or more
                if (isMatch0OrMoreCharacters) {
                    isMatch = true;
                    if (nextCharacter == nextCharacterToMatch) {
                        stringIndex++;
                        continue;
                    } else {
                        isMatch0OrMoreCharacters = false;
                        break;
                    }
                }

                if (nextCharacterToMatch == nextCharacter || isMatchAnyCharacter) {
                    isMatch = true;
                    isMatchAnyCharacter = false;
                    stringIndex++;
                    break;
                }

                isMatch = false;
                break;
            }

            // We didn't match break out of loop early
            if (!isMatch) {
                break;
            }
        }

        return isMatch;
    }

    private boolean isNextCharacterStar(int index, String pattern) {
        return index + 1 < pattern.length() && pattern.charAt(index + 1) == '*';
    }
}
