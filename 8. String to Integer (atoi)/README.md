# String to Integer (atoi)
Implement `atoi` which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

**Note:**

* Only the space character `' '` is considered a whitespace character.
* Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: `[−2<sup>31</sup>,  2<sup>31</sup> − 1]`. If the numerical value is out of the range of representable values, `2<sup>31</sup> − 1` or `−2<sup>31</sup>` is returned.
 

**Example 1:**
```
Input: str = "42"
Output: 42
```
**Example 2:**
```
Input: str = "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign. Then take as many numerical digits as possible, which gets 42.
```
**Example 3:**
```
Input: str = "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
```
**Example 4:**
```
Input: str = "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical digit or a +/- sign. Therefore no valid conversion could be performed.
```
**Example 5:**
```
Input: str = "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Therefore INT_MIN (−2<sup>31</sup>) is returned.
 ```

**Constraints:**

* `0 <= s.length <= 200`
* `s` consists of English letters (lower-case and upper-case), digits, `' '`, `'+'`, `'-'` and `'.'`.

## Solution
Solving this problem is relatively easy mainly becuase the problem explanation is basically giving us the atoi algorithm to write. The only tricky part here is to put in the checks in the right location to break out early while iterating over the character array in our string. Since we only care about `' '`, `'+'`, `'-'`, and digits, these are the characters that we'll be focusing on during our character array inspection; anything else outside the range of this scope will automatically kick us out of the loop conditional. Additionally we will have to keep a check to make sure that we're not processing an integer that is larger than 32-bits, the moment we go larger than 32-bits we return the `MAX_INT` or `MIN_INT` values.
### Pseudo Code
```
for character in s
  if character == ' '
    if not isLeadingSpace:
      break
  elif character == '+' or character == '-':
    if isLeadingSpace:
      isNegative = character == '-' ? true : false
      isLeadingSpace = false
    else:
      break
  elif isDigit(character):
    integerToReturn *= 10
    integerToReturn += int(character)
    if integerToReturn < -2**31 or integerToReturn > 2**31 - 1:
      integerToReturn = isNegative ? -2**31 : 2**31 - 1
      break
  else:
    break;

integerToReturn = isNegative ? integerToReturn * -1 : integerToReturn
return integerToReturn
```