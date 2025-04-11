package org.example.implementations;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null){
            if (list1.val < list2.val){
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        return list1 == null ? list2 : list1;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);
        ListNode listNode = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}