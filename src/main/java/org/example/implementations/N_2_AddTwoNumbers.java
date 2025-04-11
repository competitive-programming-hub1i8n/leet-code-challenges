package org.example.implementations;

import org.example.types.ListNode;

public class N_2_AddTwoNumbers {
    public void printList(ListNode list){
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header, auxLe;
        int aux = 0;
        int res;
        auxLe = new ListNode(0);
        header = auxLe;
        while (l1 != null || l2 != null) {
            int x = l1 != null? l1.val : 0;
            int y = l2 != null? l2.val : 0;
            res = x + y + aux;
            aux = res/10;
            auxLe.next = new ListNode(res % 10);
            auxLe = auxLe.next;
            if (l1 != null) {
                if (l1.next == null && aux > 0){
                    l1.next = new ListNode(aux);
                    aux = 0;
                }
                l1 = l1.next;
            }
            if (l2 != null)
                l2 = l2.next;
        }

        return header.next;
    }

}
