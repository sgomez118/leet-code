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

        // Set the last .* state
        int dotStarIndex = 0;

        // We want to iterate through the pattern since its going to be the
        // driver to search for repeated characters
        for (int patternIndex = 0; patternIndex < p.length(); patternIndex++) {
            // Restart state
            isMatch = false;

            char nextCharacterToMatch = p.charAt(patternIndex);

            isMatchAnyCharacter = nextCharacterToMatch == '.';

            if (isNextCharacterStar(patternIndex, p)) {
                // Move to next stop character.
                patternIndex++;
                isMatch0OrMoreCharacters = true;
            }

            // The .* state
            if (isMatchAnyCharacter && isMatch0OrMoreCharacters) {
                // Save state in the event we must retract our state
                dotStarIndex = patternIndex;

                // Find the next non-star state on the pattern
                nextCharacterToMatch = getNextNonStarPatternCharacter(patternIndex, p);

                // We couldn't find a valid state we had to forcefully reach
                if (nextCharacterToMatch == Character.MIN_VALUE) {
                    return true;
                }

                while (stringIndex < s.length()) {
                    if (nextCharacterToMatch == s.charAt(stringIndex)) {
                        isMatch = true;
                        break;
                    } else {
                        stringIndex++;
                    }
                }

                // If we matched, continue processing
                if (isMatch) {
                    continue;
                }

                // We didn't match and we're at the end of the string
                if (!isMatch && stringIndex >= s.length()) {
                    break;
                }
            }

            // * state
            if (isMatch0OrMoreCharacters) {
                isMatch = true;

                while (stringIndex < s.length()) {
                    if (nextCharacterToMatch == s.charAt(stringIndex)) {
                        stringIndex++;
                    } else {
                        break;
                    }
                }

                isMatch0OrMoreCharacters = false;

                // If we reached the end of the string, we overshot
                if (stringIndex >= s.length() && getNextNonStarPatternCharacter(patternIndex, p) != Character.MIN_VALUE) {
                    stringIndex--;
                }

                // Continue if we matched
                if (isMatch) {
                    continue;
                }
            }

            // Pop next character
            char nextCharacter = s.charAt(stringIndex);

            // Next state
            if (nextCharacterToMatch == nextCharacter || isMatchAnyCharacter) {
                isMatch = true;
                isMatchAnyCharacter = false;
                stringIndex++;
            }

            if (!isMatch) {
                // We didn't match break out of loop early
                if (stringIndex >= s.length()) {
                    break;
                }

                // If we're still in a .* state and got a false positive from above, then revert back to state
                if (dotStarIndex > 0) {
                    patternIndex = dotStarIndex;
                } else {
                    break;
                }
            }
        }

        // We didn't finish matching the entire string
        if (stringIndex < s.length()) {
            isMatch = false;
        }

        return isMatch;
    }

    private boolean isNextCharacterStar(int index, String pattern) {
        return index + 1 < pattern.length() && pattern.charAt(index + 1) == '*';
    }

    private char getNextNonStarPatternCharacter(int index, String pattern) {
        while (index < pattern.length()) {
            if (pattern.charAt(index) == '*' || isNextCharacterStar(index, pattern)) {
                index++;
            } else {
                return pattern.charAt(index);
            }
        }
        return Character.MIN_VALUE;
    }
}
