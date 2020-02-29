package com.scottygomez.leetcode;

/**
 * LongestSubstringWithoutRepeatingCharacters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    
    private static int lengthOfLongestSubstring(String word) {
        int maxLength = 0;
        if (word != null) {
            Character[] queue = new Character[word.length()];
            for (Character character : word.toCharArray()) {
                if (isCharacterInQueue(character, queue)) {
                    dequeue(character, queue);
                }
                enqueue(character, queue);
                int length = countQueue(queue);
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    private static boolean isCharacterInQueue(Character character, Character[] queue) {
        boolean isInQueue = false;
        for (int index = 0; index < queue.length; ++index) {
            if (queue[index] == character) {
                isInQueue = true;
                break;
            }
        }
        return isInQueue;
    }

    private static void enqueue(Character character, Character[] queue) {
        for (int index = 0; index < queue.length; ++index) {
            if (queue[index] == null) {
                queue[index] = character;
                break;
            }
        }
    }

    private static void dequeue(Character character, Character[] queue) {
        // Remove elements as they came in until and including character to remove
        // If the character doesn't exists, you effectively clear the entire queue
        for (int index = 0; index < queue.length; index++) {
            if (character != queue[index]) {
                queue[index] = null;
            } else {
                for (int start = index + 1; start < queue.length; start++) {
                    queue[start-index-1] = queue[start];
                }
                break;
            }
        }
    }

    private static int countQueue(Character[] queue) {
        int count = 0;
        for (Character character : queue) {
            if (character != null) {
                ++count;
            }
        }
        return count;
    }
}