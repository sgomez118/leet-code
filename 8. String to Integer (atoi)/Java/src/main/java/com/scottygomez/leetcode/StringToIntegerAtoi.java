package com.scottygomez.leetcode;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        int integerToReturn = 0;

        // Make sure string is not null and string is not empty
        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        boolean isLeadingSpace = true;
        boolean isNegative = false;
        out: for (char character : s.toCharArray()) {
            switch (character) {
                case ' ':
                    if (!isLeadingSpace) {
                        break out;
                    }
                    break;
                case '+':
                    if (isLeadingSpace) {
                        isNegative = false;
                        isLeadingSpace = false;
                    } else {
                        break out;
                    }
                    break;
                case '-':
                    if (isLeadingSpace) {
                        isNegative = true;
                        isLeadingSpace = false;
                    } else {
                        break out;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    if (integerToReturn * 10 < -2 << 30 || integerToReturn * 10 > 2 << 30 - 1) {
                        integerToReturn = isNegative ? -2 << 30 : 2 << 30 -1;
                        break out;
                    }
                    integerToReturn *= 10;
                    integerToReturn += Integer.valueOf(String.valueOf(character));
                    isLeadingSpace = false;
                    break;
                default:
                    break out;
            }
        }

        // Put the sign back into place
        integerToReturn = isNegative ? integerToReturn * -1 : integerToReturn;

        return integerToReturn;
    }
}