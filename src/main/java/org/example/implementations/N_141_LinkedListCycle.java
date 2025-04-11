package org.example.implementations;

import org.example.types.ListNode;


public class N_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        while (fastPointer != null && fastPointer.next != null) {
            if (fastPointer == slowPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode  head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        N_141_LinkedListCycle n141 = new N_141_LinkedListCycle();
        System.out.println(n141.hasCycle(head));;


        System.out.println("====================================");
        ListNode nodes = new ListNode(new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5});
        //head = nodes[0];
        nodes.print();
        System.out.println("====================================");
        ListNode head2 = nodes.search(-21);
        System.out.println(n141.hasCycle(head2));
    }
}
