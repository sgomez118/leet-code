package com.scottygomez.leetcode;

public class AddTwoNumbers {

    public static void main(String[] args) {
        // Original example 342 + 465 = 807
        // (2->4->3) + (5->6->4) = (7->0->8)
        addTwoNumbersAndPrintValue(342, 465);

        // Additional test cases
        // 1 + 1 = 2
        addTwoNumbersAndPrintValue(1, 1);
        // 9 + 1 = 10
        addTwoNumbersAndPrintValue(9, 1);
        // 10 + 1 = 11
        addTwoNumbersAndPrintValue(10, 1);
        // 1 + 10 = 11
        addTwoNumbersAndPrintValue(1, 10);
        // 99 + 99 = 198
        addTwoNumbersAndPrintValue(99, 99);
        // 99 + 101 = 200
        addTwoNumbersAndPrintValue(99, 101);
    }

    public static ListNode addTwoNumbers(ListNode operand1, ListNode operand2) {
        // Init stuff
        ListNode result = null;
        ListNode pointer = null;
        int remainder = 0;

        // Verify valid inputs
        while (operand1 != null || operand2 != null) {

            // Validate and add values plus remainder
            int digit1 = operand1 != null ? operand1.val : 0;
            int digit2 = operand2 != null ? operand2.val : 0;
            int resultDigit = digit1 + digit2 + remainder;

            // Verify we have only digits 0-9
            if (resultDigit > 9) {
                remainder = 1;
                resultDigit -= 10;
            } else {
                // Reset the remainder when we're not carrying over
                remainder = 0;
            }

            // Store original pointer
            if (result == null) {
                result = new ListNode(resultDigit);
                pointer = result;
            } else {
                // Update pointer
                pointer.next = new ListNode(resultDigit);
                pointer = pointer.next;
            }

            // Update pointers
            operand1 = operand1 != null ? operand1.next : null;
            operand2 = operand2 != null ? operand2.next : null;
        }

        // Any remainders left are added to the end of the list;
        if (remainder != 0) {
            pointer.next = new ListNode(remainder);
        }

        return result;
    }

    public static void addTwoNumbersAndPrintValue(int number1, int number2) {
        ListNode operand1 = convertNumberToListNode(number1);
        ListNode operand2 = convertNumberToListNode(number2);
        ListNode result = addTwoNumbers(operand1, operand2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }

    /**
     * Converts a non-negative number into a ListNode in reverse order
     * 
     * @param number the non-negative integer to convert
     * @return the number in ListNode format
     */
    public static ListNode convertNumberToListNode(int number) {
        ListNode listNodeNumber = null;
        ListNode pointer = null;

        if (number > 0) {
            int digits = number;
            while (digits > 0) {
                int remainder = digits % 10;
                if (listNodeNumber == null) {
                    listNodeNumber = new ListNode(remainder);
                    pointer = listNodeNumber;
                } else {
                    pointer.next = new ListNode(remainder);
                    pointer = pointer.next;
                }
                digits /= 10;
            }
        }
        return listNodeNumber;
    }

    /**
     * This structure is from leet code, using this to be able to code offline.
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}