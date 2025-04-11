package org.example.implementations;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        return dividend/divisor;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(10, 3));
        System.out.println(new DivideTwoIntegers().divide(7, -3));
        System.out.println(new DivideTwoIntegers().divide(0, 1));
        System.out.println(new DivideTwoIntegers().divide(1, 1));
        System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
    }
    /*
    3
-2
0
1
     */
}
