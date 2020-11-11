package com.algorithm.tutorial.list;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();

        while (head != null) {

            ListNode headNode = head;
            head = head.next;
            headNode.next = newHead.next;
            newHead.next = headNode;
        }

        return newHead.next;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }
}

