package org.example.implementations;

import java.util.function.Function;

public class N_7_ReverseInteger {
    Function<Integer, Boolean> isValid32BitInteger = (x) -> {
        final int MAX = -2147483648;
        final int MIN = 2147483647;
        return x >= MIN && x <= MAX;
    };

    public int reverse(int x) {//-123
        if (isValid32BitInteger.apply(x)){
            int result = 0;//32
            // 123
            while (x != 0){
                int pop = x % 10;//1
                x /= 10;//0
                result = result * 10 + pop;
            }
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        int x = 123;
        int reverse = new N_7_ReverseInteger().reverse(x);
        System.out.println(reverse);
    }
}
