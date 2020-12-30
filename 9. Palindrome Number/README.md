# Palindrome Number
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

**Follow up**: Could you solve it without converting the integer to a string?


**Example 1:**
```
Input: x = 121
Output: true
```
**Example 2:**
```
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```
**Example 3:**
```
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```
**Example 4:**
```
Input: x = -101
Output: false
```

**Constraints:**

* `[−2<sup>31</sup>,  2<sup>31</sup> − 1]`

## Solution
There are many simple solutions that come in to mind, the easiest of which is to simply get the "length" of the integer and push it into an array. By definition negative numbers and number ending in 0 are not palindromes, so we need to discard those values first. Using an array structure, we can pick out the middle and check the sides until they reach the middle or break. This solution is acceptable because the length of the integer is relatively "small" (32-bits makes it 10 characters at most). An improvement to this solution would be to use a stack to push the elements into the array and start popping once we've reached the middle. I'm sure there's a mathematical cleaver way to do this without an array (foreshadowing here), but this is the naïve implementation.

x = 1221<br/>
length = 4<br/>
array = 12<br/>
new value of x = 12<br/>
return newX == array

<br/>After looking at the solution, I didn't realize that you can the reversed integer by doing
```
revertedNumber = 0;
while x > revertedNumber:
    revertedNumber = revertedNumber * 10 + x % 10;
    x /= 10;
```

Then all we have to do is to check that x == reversedNumber.
### Pseudo Code
I'm gong to publish the posted solution for this implementation since it makes the most sense.
```
if x < 0 or (x % 10 == 0 and x != 0):
    return false;

revertedNumber = 0;
while x > revertedNumber:
    revertedNumber = revertedNumber * 10 + x % 10;
    x /= 10;

return x == revertedNumber or x == revertedNumber/10
```