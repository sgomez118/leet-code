package com.scottygomez.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        long reversed = 0;

        // Get the sign of the integer
        boolean isNegative = x < 0;
        x = Math.abs(x);

        while (x != 0) {
            reversed *= 10;
            reversed += x % 10;
            x /= 10;
            // If larger than "32-bits" return 0
            if (reversed < -2 << 30 || reversed > (2 << 30) - 1) {
                return 0;
            }
        }

        // Put the sign back into place
        reversed = isNegative ? reversed * -1 : reversed;

        return (int)reversed;
    }
}
