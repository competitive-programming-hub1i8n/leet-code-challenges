package org.example.implementations;

import java.util.Arrays;

public class N_344_ReverseString {
    public static char[] reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return s;
    }
    public static void main(String[] args) {
        char[] in = {'h','e','l','l','o'};
        char[] out = reverseString(in);
        System.out.println(Arrays.toString(out));

        System.out.println("====================");

        char[] in2 = {'H','a','n','n','a','h'};
        char[] out2 = reverseString(in2);
        System.out.println(Arrays.toString(out2));


        System.out.println("====================");


        char[] in3 = {'a', 'b', 'c', 'd', 'e'};
        char[] out3 = reverseString(in3);
        System.out.println(Arrays.toString(out3));


        System.out.println("====================");

        char[] in4 = {'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c', 'a', 'n', 'a', 'l', ':', ' ', 'P'};
        char[] out4 = reverseString(in4);
        System.out.println(Arrays.toString(out4));
    }
}
