You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in **reverse order** and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Example:**
```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

## Solution
We want to iterate each list at the same time. Add each digit, if there is a carry over, add the carry over. If the result is greater than 9, flag the carry over and set the remainder as the result. Repeat until both list have been consumed, if carry over, add node to the end of the list.

### Pseudo Code
```
remainder = 0

while listNode1.hasNext || listNode2.hasNext:
    digit1 = listNode1.hasNext ? listNode1.next : 0
    digit2 = listNode2.hasNext ? listNode2.next : 0
    resultNode.next = digit1 + digit2 + remainder
    
    if resultNode.next > 9:
        remainder = 1
        resultNode.next -= 10
    else:
        remainder = 0

if remainder != 0:
    resultNode.next = remainder

return resultNode
```