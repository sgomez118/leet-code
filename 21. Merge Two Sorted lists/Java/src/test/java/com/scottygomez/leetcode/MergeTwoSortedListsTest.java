package com.scottygomez.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {
    
    @Test
    public void mergeTwoLists_FromExample1_ShouldReturn_1_1_2_3_4_4() {
        // Arrange
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        int[] expected = new int[]{1,1,2,3,4,4};

        // Act
        ListNode actualListNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        int[] actual = new int[6];
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
    public void mergeTwoLists_FromExample2_ShouldReturnNull() {
        // Arrange
        ListNode list1 = null;
        ListNode list2 = null;
        int[] expected = new int[0];

        // Act
        ListNode actualListNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
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
    public void mergeTwoLists_FromExample3_ShouldReturn_0() {
         // Arrange
        ListNode list1 = null;
        ListNode list2 = new ListNode(0);
        int[] expected = new int[]{0};

        // Act
        ListNode actualListNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
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
    public void mergeTwoLists_EmptySString_ShouldReturn1_2_3() {
        // Arrange
        ListNode list1 = new ListNode(1, new ListNode(3));
        ListNode list2 = new ListNode(2);
        int[] expected = new int[]{1,2,3};

        // Act
        ListNode actualListNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        int[] actual = new int[3];
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
    public void mergeTwoLists_SingleChar_ShouldReturnNegative1_0_3_4_4_5() {
        // Arrange
        ListNode list1 = new ListNode(-1, new ListNode(3, new ListNode(4)));
        ListNode list2 = new ListNode(0, new ListNode(4, new ListNode(5)));
        int[] expected = new int[]{-1,0,3,4,4,5};

        // Act
        ListNode actualListNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        int[] actual = new int[6];
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
