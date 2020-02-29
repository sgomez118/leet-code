# Median of Two Sorted Arrays
There are two sorted arrays **nums1** and **nums2** of size m and n respectively. Fin d the median of the two sorted arrays. The overall run time complexity should be O(log(m + n)). You may assume **nums1** and **num2** cannot both be empty.

**Example 1:**
```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
```
**Example 2:**
```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```
## Solution
The naive solution to this problem would be to create a new array of size m + n and perform an in-order insertion onto the new array. Unfortunately we break the time complexity restriction of O(log(m+n)), because the operation is linear O(m + n). Of course this is a hard problem and I couldn't come up with the answer by myself, I must thank the internet and Tushar Roy's [YouTube video](https://youtu.be/LPFhl65R7ww) explaining the solution to the problem.

The solution is really a modification of the original binary search algorithm, that takes into account a pivot points of two arrays where we perform the "binary steps" on the smaller array just like in a binary search algorithm and use that pivot point to find the pivot point of our combined larger array minus the pivot point to offset the index of the second array
```
pivot = (left + right) / 2
combinedPivot = (nums1.length + nums2.length + 1) / 2 - pivot
```
Plus 1 is a magical number that plays well with both odd and even number of elements.

From there its just a standard binary search algorithm where largest element on the left side of the first array must be less than or equal to the smallest element on the right side of the second array AND the largest element of the left side of the second array must be less than or equal to the smallest element on the right side of the first array.

### Pseudo Code
I'm putting up the binary search from Wikipedia for comparison.

A is the array
n is the number of elements in the array
T is the target element to find
```
function binary_search(A, n, T) is
    L := 0
    R := n − 1
    while L ≤ R do
        m := floor((L + R) / 2)
        if A[m] < T then
            L := m + 1
        else if A[m] > T then
            R := m - 1
        else:
            return m
    return unsuccessful
```
A is the first array
m is the length of the first array
B is the second array
n is the length of the second array
```
function medianOfSortedArrays(A, m, B, n):
    L := 0
    R := m
    while L < R:
        p := floor((L + R) / 2)
        p2 := floor((m + n + 1) / 2) - p
        if A[p-1] > B[p2]:
            L := p - 1
        else:
            R := p + 1
    return (m + n) % 2 == 0 ? avg(max(A[p-1], B[p2-1]), min(A[p], B[p2])) : max(A[p-1], B[p2-1])
```