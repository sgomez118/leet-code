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

        for (int currentRowNumber = 0; currentRowNumber < numberOfRows; currentRowNumber++) {
            int index = currentRowNumber;

            // Make sure index is not beyond the word index
            if (index < word.length()) {
                // Start iterating through columns
                int currentColumnNumber = 0;
                
                do {
                    if (currentRowNumber > 0 && index > numberOfColumns + numberOfColumns) {
                        if (index - currentRowNumber < word.length()) {
                            stringBuilder.append(word.charAt(index - currentRowNumber));
                        }
                        if (index + currentRowNumber < word.length()) {
                            stringBuilder.append(word.charAt(index + currentRowNumber));
                        }
                    } else {
                        stringBuilder.append(word.charAt(index));
                    }
                    
                    currentColumnNumber++;
                    index = (numberOfRows + numberOfColumns) * currentColumnNumber;
                } while (index < word.length());
            }
        }

        return stringBuilder.toString();
    }
}
