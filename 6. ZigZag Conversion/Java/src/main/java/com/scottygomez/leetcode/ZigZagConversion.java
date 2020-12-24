package com.scottygomez.leetcode;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println("hello");
    }
    public static String convert(String word, int numberOfRows) {

        if (numberOfRows == 1 || numberOfRows >= word.length()) {
            return word;
        }

        StringBuilder stringBuilder = new StringBuilder();
        // "Columns" start to appear after 2 rows
        int numberOfColumns = numberOfRows - 2;

        // Need to calculate last slot in the last column
        int numberOfSlotsToCompleteColumn = numberOfRows - word.length() % (numberOfRows + numberOfColumns);

        // If the number of slots to complete column between 0 and numberOfRows - 1 then use the natural last column
        // given by the length of the string, else increase the last column number by 1
        int lastColumnIndex = word.length();
        if (0 > numberOfSlotsToCompleteColumn || numberOfSlotsToCompleteColumn >= numberOfRows) {
            lastColumnIndex = (int) Math.ceil(word.length() / (double)(numberOfRows + numberOfColumns)) * (numberOfRows + numberOfColumns);
        }

        for (int currentRowNumber = 0; currentRowNumber < numberOfRows; currentRowNumber++) {
            int index = currentRowNumber;

            // Make sure index is not beyond the word index
            if (index < word.length()) {
                // Start iterating through columns
                int currentColumnNumber = 0;

                do {
                    if (currentRowNumber > 0 && index >= numberOfRows + numberOfColumns) {
                        if (index - currentRowNumber < word.length() && currentRowNumber < numberOfRows - 1) {
                            stringBuilder.append(word.charAt(index - currentRowNumber));
                        }
                        if (index + currentRowNumber < word.length()) {
                            stringBuilder.append(word.charAt(index + currentRowNumber));
                        }
                    } else {
                        if (index < word.length()) {
                            stringBuilder.append(word.charAt(index));
                        }
                    }
                    
                    currentColumnNumber++;
                    index = (numberOfRows + numberOfColumns) * currentColumnNumber;
                } while (index <= lastColumnIndex);
            }
        }

        return stringBuilder.toString();
    }
}
