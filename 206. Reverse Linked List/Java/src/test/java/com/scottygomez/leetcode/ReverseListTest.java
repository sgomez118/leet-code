package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class ReverseListTest {
    
    @Test
    public void reverseList_FromExample1_ShouldReturn_5_4_3_2_1() {
        // Arrange
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int[] expected = new int[]{5,4,3,2,1};

        // Act
        ListNode actualListNode = new ReverseList().reverseList(head);
        int[] actual = new int[5];
        int i = 0;
        while (actualListNode != null) {
            actual[i] = actualListNode.val;
            actualListNode = actualListNode.next;
            i++;
        }

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseList_FromExample2_ShouldReturn2_1() {
        // Arrange
        ListNode head = new ListNode(1, new ListNode(2));
        int[] expected = new int[]{2,1};

        // Act
        ListNode actualListNode = new ReverseList().reverseList(head);
        int[] actual = new int[2];
        int i = 0;
        while (actualListNode != null) {
            actual[i] = actualListNode.val;
            actualListNode = actualListNode.next;
            i++;
        }

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseList_FromExample3_ShouldReturn_Null() {
         // Arrange
        ListNode head = null;
        int[] expected = new int[0];

        // Act
        ListNode actualListNode = new ReverseList().reverseList(head);
        int[] actual = new int[0];
        int i = 0;
        while (actualListNode != null) {
            actual[i] = actualListNode.val;
            actualListNode = actualListNode.next;
            i++;
        }

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseList_1Element_ShouldReturn1() {
        // Arrange
        ListNode head = new ListNode(1);
        int[] expected = new int[]{1};

        // Act
        ListNode actualListNode = new ReverseList().reverseList(head);
        int[] actual = new int[1];
        int i = 0;
        while (actualListNode != null) {
            actual[i] = actualListNode.val;
            actualListNode = actualListNode.next;
            i++;
        }

        // Assert
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseList_5000Elements_ShouldReturnReversed() {
        // Arrange
        final int length = 5000;
        ListNode head = null;
        int[] expected = new int[length];
        for (int i = 0; i < expected.length; ++i) {
            head = new ListNode(i, head);
            expected[i] = i;
        }

        // Act
        long start = System.nanoTime();
        ListNode actualListNode = new ReverseList().reverseList(head);
        long end = System.nanoTime();
        System.out.println("time to run: " + (end - start));
        int[] actual = new int[length];
        int i = 0;
        while (actualListNode != null) {
            actual[i] = actualListNode.val;
            actualListNode = actualListNode.next;
            i++;
        }

        // Assert
        assertArrayEquals(expected, actual);
    }
}
