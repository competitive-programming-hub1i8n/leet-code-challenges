package org.example.implementations;

import org.example.types.ListNode;

public class N_143_ReorderList {
    public void reorderList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = reverseList(findMiddleNode(head));

        while (p2 != null && p2.next != null){
            ListNode tmp = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = tmp;
            p1 = tmp;
        }
    }

    public ListNode findMiddleNode(ListNode head){
        ListNode fazstPointer = head;
        ListNode eslowPointer = head;

        while (fazstPointer != null && fazstPointer.next != null){
            fazstPointer = fazstPointer.next.next;
            eslowPointer = eslowPointer.next;
        }
        return eslowPointer;
    }

    public ListNode reverseList(ListNode head) {
        ListNode actual = head;
        ListNode prev = null;
        while (actual != null){
            ListNode aux = actual.next;
            actual.next = prev;
            prev = actual;
            actual = aux;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(5);

        head.next = node;
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        N_143_ReorderList list = new N_143_ReorderList();
        list.reorderList(head);

        head.print();
    }
}
