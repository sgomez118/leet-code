# Longest Substring Without Repeating Characters
Given a string, find the length of the **longest substring** without repeating characters.

**Example 1:**
```
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3.
```
**Example 2:**
```
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```
**Example 3:**
```
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```
## Solution
Have a sliding queue window. Basic idea is to increase the queue size for each *consecutive* unique element in the queue and dequeue elements up to the inserted duplicate element. As we count, we keep in memory the max count of the longest substring.

Taking a look at the first example

| Operation | Character | Queue | Count |
| --------- | --------- | ----- | ----- |
| 1         | a         | a     | 1     |
| 2         | b         | ab    | 2     |
| 3         | c         | abc   | 3     |
| 4         | a         | bca   | 3     |
| 5         | b         | cab   | 3     |
| 6         | c         | abc   | 3     |
| 7         | b         | cb    | 2     |
| 8         | b         | b     | 1     |

### Pseudo Code
In this code we'll have 3 magic functions that will be *enqueue(element)* which adds an element to the queue, *dequeue(element)* which will remove all elements up to the input element, and *count(queue)* which counts all elements in the queue.

```
maxLength = 0
char[] queue = new char[words.length]

for character in word
    if character in queue
        dequeue(character)
    enqueue(character)
    if maxLength < count(queue)
        maxLength = count(queue)

return maxLength
```