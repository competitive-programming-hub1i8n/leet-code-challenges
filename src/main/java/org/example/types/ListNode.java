package org.example.types;

public class ListNode{
    public int val;
    public ListNode next;

    ListNode() {}
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] array) {
        this.val = array[0];
        ListNode cur = this;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
    }

    public void print() {

    	ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void print(ListNode head) {

        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode search(int value) {

    	ListNode cur = this;
        while (cur != null) {
            if (cur.val == value) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
