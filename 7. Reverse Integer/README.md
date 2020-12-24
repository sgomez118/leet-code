# Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.
**Note:**
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2<sup>31</sup>,  2<sup>31</sup> − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

**Example 1:**
```
Input: x = 123
Output: 321
```

**Example 2:**
```
Input: x = -123
Output: -321
```

**Example 3:**
```
Input: x = 120
Output: 21
```

**Example 4:**
```
Input: x = 0
Output: 0
```

**Constraints:**
* -2<sup>31</sup> <= x <= 2<sup>31</sup> - 1

## Solution
This is a classic computer science problem in a first year computer science course. The only gotcha here can be making sure the reversed int is indeed also an integer (i.e. Keep checking current reversed integer is less than 32 bits as we reverse).

The trick here is using division, modulus and multiplication in the right order. Since we're dealing with base 10 number system we want to first start off with the reverse variable we're going to be returning set to 0 and multiply the value by 10 every time the update `x` value isn't 0. Next we get the modulus of the original number `x` by doing modulo 10 and getting the first digit in `x` and adding that to our reversed integer. We then do integer division of 10 on `x` to move to the next place value and repeat the process. To check that the reversed integer isn't larger than 32 bits we check the current number to be less than 2 << 30 or 2 << 30 - 1 during the process (else we break away from the loop by returning 0). Repeat the process until `x` reaches 0 and we conclude to finishing the process by making sure the sign is correct from original number `x` and returned revered integer. 

### Pseudo Code
```
while x != 0:
    reversed *= 10;
    reversed += x % 10;
    x /= 10;
    # If larger than "32-bits" return 0
    if (reversed < -2 << 30 || reversed > (2 << 30) - 1):
        return 0;
```