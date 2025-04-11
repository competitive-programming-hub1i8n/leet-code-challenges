package org.example.implementations;

public class N_1945_SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            sb.append(convertToNumber(c));
        }
        int res = sumOfDigits(sb.toString());
        for (int i = 1; i < k; i++) {
            int aux = sumOfDigits(String.valueOf(res));
            res = aux;
        }
        return res;
    }

    public int convertToNumber(char c){
        return c - 'a' + 1;
    }

    public int sumOfDigits(String num){
        return num.chars().map(Character::getNumericValue).sum();
    }

    public static void main(String[] args) {
        String word = "leetcode";
        int k = 2;
        int lucky = new N_1945_SumOfDigitsOfStringAfterConvert().getLucky(word, k);
        System.out.println(lucky);

        word = "iiii";
        k = 1;
        lucky = new N_1945_SumOfDigitsOfStringAfterConvert().getLucky(word, k);
        System.out.println(lucky);

        word = "zbax";
        k = 2;
        lucky = new N_1945_SumOfDigitsOfStringAfterConvert().getLucky(word, k);
        System.out.println(lucky);
    }
}
