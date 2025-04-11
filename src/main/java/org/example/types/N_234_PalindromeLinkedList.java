package org.example.types;

public class N_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode middleNode = revertLinkedList(searchMiddleNode(head));
        return comparator(head, middleNode);
    }

    public ListNode searchMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast  != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode revertLinkedList(ListNode head) {
        ListNode actual = head;
        ListNode prev = null;

        while (actual != null) {
            ListNode aux = actual.next;
            actual.next = prev;
            prev = actual;
            actual = aux;
        }
        return prev;
    }

    public boolean comparator(ListNode head, ListNode  middle) {
        boolean validator = true;
        while (validator && head != null && middle != null) {
            if (head.val != middle.val) {
                validator = false;
            }
            head = head.next;
            middle = middle.next;
        }
        return validator;
    }


    public void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        N_234_PalindromeLinkedList n234 = new N_234_PalindromeLinkedList();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        System.out.println(n234.isPalindrome(head));

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(1);

        head2.next = node21;
        node21.next = node22;
        node22.next = node23;

        System.out.println(n234.isPalindrome(head2));;

        System.out.println("====================================");
        ListNode head3 = new ListNode(1);
        ListNode node31 = new ListNode(2);
        head3.next = node31;
        System.out.println(n234.isPalindrome(head3));;
    }
}
/*

// Programando Palindrome Linked List con Java

public class Main {
    public static void main(String[] args) {
        // Tu cÃ³digo aquÃ­
    }


public class Nodo {
    int valor;
    Nodo siguiente;
    Nodo() {}
    Nodo(int valor) { this.valor = valor; }
    Nodo(int valor, Nodo siguiente) { this.valor = valor; this.siguiente = siguiente;  }
}

public boolean isPalindrome(Nodo cabeza){
    if (cabeza == null){ return true; }
    Nodo finPrimeraMitad = encontrarMitad(cabeza);
    Nodo comienzoSegundaMitad = reversarLista(cabeza);
    boolean esPalindromo = true;
    Nodo p1 = cabeza;
    Nodo p2 = comienzoSegundaMitad;

    while (esPalindromo == true && p2 != null){
        if (p1.valor != p2.valor){
            esPalindromo = false;
        }
        p1 = p1.siguiente;
        p2 = p2.siguiente;
    }
    finPrimeraMitad.siguiente = reversarLista(comienzoSegundaMitad);
    return esPalindromo;
};

public Nodo encontrarMitad(Nodo cabeza){
    Nodo rapido = cabeza;
    Nodo lento = cabeza;
    while(rapido.siguiente != null && rapido.siguiente.siguiente != null ){
        rapido = rapido.siguiente.siguiente;
        lento = lento.siguiente;
    }
    return lento;
};

public Nodo reversarLista(Nodo cabeza){
    Nodo anterior = null;
    Nodo actual = cabeza;
    while (actual != null){
        Nodo siguienteTemporal = actual.siguiente;
        actual.siguiente = anterior;
        anterior = actual;
        actual = siguienteTemporal;
    }
    return actual;
}

}
 */
