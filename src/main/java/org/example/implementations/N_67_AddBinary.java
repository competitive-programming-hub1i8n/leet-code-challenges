package org.example.implementations;

import java.util.function.Function;

public class N_67_AddBinary {
    public String addBinary(String a, String b) {
        int decimalA = binaryToDecimal.apply(a);
        int decimalB = binaryToDecimal.apply(b);
        int sum = decimalA + decimalB;
        String res = decimalToBinary.apply(sum);
        return res.isEmpty() ? "0" : res;

    }

    Function<String, Integer> binaryToDecimal = (binary) -> {
        int decimal = 0;
        int n = 0;
        while (!binary.isEmpty()) {
            int temp = Integer.parseInt(String.valueOf(binary.charAt(binary.length() - 1)));
            decimal += (int) (temp * Math.pow(2, n));
            binary = binary.substring(0, binary.length() - 1);
            n++;
        }
        return decimal;
    };

    Function<Integer, String> decimalToBinary = (decimal) -> {
        StringBuilder binary = new StringBuilder();
        while (decimal != 0) {
            binary.append(decimal % 2);
            decimal = decimal / 2;
        }
        return binary.reverse().toString();
    };

    public static void main(String[] args) {
        N_67_AddBinary addBinary = new N_67_AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
        System.out.println(addBinary.addBinary("0", "0"));
    }
}
