package ru.shapik.leet_code.medium.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode first = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode second = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        addTwoNumbers.addTwoNumbers(first, second);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> nodeStack = new Stack<>();
        int num = 0;
        while (l1 != null || l2 != null || num > 0) {
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            nodeStack.push(new ListNode(num%10));
            num /=10;
        }


        ListNode node = null;
        while (!nodeStack.isEmpty()) {
            ListNode newNode = nodeStack.pop();
            newNode.next = node;
            node = newNode;
        }

        return node;
    }
}

class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
