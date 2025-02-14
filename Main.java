package org.example;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};

        Solution solution = new Solution();

        for (int num : arr) {
            System.out.print(num + " ");
        }

        solution.moveZeroes(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode head_test = head;
        while (head_test != null) {
            System.out.println(head_test.val);
            head_test = head_test.next;
        }

        ListNode head_2 = solution.reverseList(head);

        head_test = head_2;
        while (head_test != null) {
            System.out.println(head_test.val);
            head_test = head_test.next;
        }

        String s = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        System.out.println(Solution.isValid(s));
        System.out.println(Solution.isValid(s2));
        System.out.println(Solution.isValid(s3));
    }
}

class ListNode {
    int val = 0;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}

class Solution {
    public void moveZeroes(int[] arr) {
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if (!isCorrectClosed(open, ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isCorrectClosed(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}