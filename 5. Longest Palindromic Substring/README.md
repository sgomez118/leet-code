# Longest Palindromic Substring
Given a string `s`, find the longest palindromic substring in `s`.

**Example 1:**
```
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

**Example 2:**
```
Input: "cbbd"
Output: "bb"
```

**Example 3:**
```
Input: s = "a"
Output: "a"
```

**Example 4:**
```
Input: s = "ac"
Output: "a"
```

**Constraints:**
* `1 <= s.length <= 1000`
* `s` consist of only digits and English letters (lower-case and/or upper-case)

## Solution
The idea is to have a moving window to find the longest palindrome in the substring. To keep the process as fast as possible we use the entire string as the starting point for the window and shrink the window by 1 character when testing if substring is a palindrome. To keep the process simple we move from left to right when checking if the substring is a palindrome.

From our example "babad"

| index range | string | is palindrome |
| ----------- | ------ | ------------- |
| 0 - 5       | babad  | no            |
| 0 - 4       | baba   | no            |
| 1 - 5       | abad   | no            |
| 0 - 3       | bab    | yes           |

&nbsp;
### Pseudo Code
```
for i = 0; i < word.length; i++ {
    left = 0;
    right = word.length - i;
    
    palindrome = word.substring(left, right);
    while right < word.length() and !isPalindrome(palindrome) {
        left += 1;
        right += 1;
        palindrome = word.substring(left, right);
    }

    if (isPalindrome(palindrome)) {
        return palindrome;
    }
}
```