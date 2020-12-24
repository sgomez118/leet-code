# ZigZag Conversion
The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
```
P   A   H   N
A P L S I I G
Y   I   R
```
And then read line by line `"PAHNAPLSIIGYIR"`
Write the code that will take a string and make this conversion given a number of rows:
```
string convert(string s, int numRows)
```

**Example 1:**
```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

**Example 2:**
```
Input: "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P    I    N
A  L S  I G
Y A  H R
P    I
```

**Example 3:**
```
Input: s = "A", numRows = 1
Output: "A"
```

**Constraints:**
* `1 <= s.length <= 1000`
* `s consists of English letters (lower-case and upper-case), ',' and '.'`
* `1 <= numRows <= 1000`

## Solution
To solve this problem, we first need to understand how many "columns" there are in total and whether our characters "overflow" the last column. For clarification a "column" are the character that come down vertically in the zig-zag pattern. The first character in each column is considered a pivot point or in other words the first row of characters in the zigzag pattern. From each pivot point we will move backward and forward in correspondence to the "row" we're currently reading with the exception of the last row there is only backward or forward movement (your personal preference). There are 3 use cases which are column not full, column full, and column overflowing. The column not full and column full can be treated the same since we have a pivot point to reach. The column overflowing presents a potential problem because getting the last characters is not possible since our "next" pivot point is an index out of bounds. To solve this issue, we create the pivot point to the next column and take precautions to avoid index out of bounds exceptions.

Let's take **example 2** through the solution. Below the rows and columns are labeled respectively. The pivot points in **example 2** would be the first row `P` `I` `N`. Given that the first column we just need to read the character (`P`) we do nothing. Our next point of interest is `I`, here we either don't move, move backwards and forwards, or we move only backward or forwards depending on the implementation (I will be moving forward in my implementation). Depending on what "row" we're reading we move accordingly, for example if we're on the 0 row then we don't move and just read `I`. If we're on either rows 1 or 2 then we move backwards *and* forwards 1 or 2 characters respectively reading characters `L` and `S` on row 1 and characters `A` and `H` on row 2. For the last row we only move forward 4 characters, which is `I` again in this example (its the `I` after the `H`). We continue the same movement for the next pivot point `N` avoiding the `?` which don't exists int the string.
```
  0    1    2
0 P    I    N
1 A  L S  I G
2 Y A  H R  ?
3 P    I    ?
```

Now let's take an example where we "overflow". In this case we use the same string, but use 5 rows instead. Here we can see that we fill up column 1, but we have a little extra (`G` in this case). For this use case we indicate that we have a total number of columns as 2 and apply the same algorithm making sure that we don't access an illegal character when reading from the string array.
```
  0       1       2
0 P       H       ?
1 A     S I     ?
2 Y   I   R   ?
3 P L     I G
4 A       N
```
### Pseudo Code
Here is the main portion of the algorithm to read each row in a "zigzag" manner. Just make sure you add the proper checks to not read in an illegal array position.
```
charCols = numRows - 2
for rowNum in numRows:
  index = rowNum
  curCol = 0
  while index < length(s):
    if rowNum > 0 and index >= numRows + charCols:
      s[index - rowNum]
      s[index + rowNum]
    else:
      s[index]
    
    curCol++
    index = (numRows + charCols) * curCol
```