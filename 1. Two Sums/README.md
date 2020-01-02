# Two Sums
Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have **exactly** one solution, and you may not use the same element twice.

**Example**:
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

## Solution
Go through the list of combinations n choose 2

From our example 4 choose 2 gives us 6.

| index | iteration |
| ----- | --------- |
| 0     | [1, 2, 3] |
| 1     | [2, 3]    |
| 2     | [3]       |

### Pseudo Code
```
for i in nums:
    for j = i + 1 in nums:
        if nums[i] + nums[j] equals target
            return i, j
```