package org.example.implementations;

public class N_2744_FindMaximumNumberStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        int counter = 0;
        int pointerA = 0;
        int pointerB = pointerA+1;
        while (pointerB < words.length){
            if (words[pointerA].equals(revert(words[pointerB]))){
                counter++;
                pointerB = pointerA +1;
                pointerA++;
            }else {
                pointerB++;
            }

        }
        return counter;
    }


    public String revert(String s){
        return new StringBuilder().append(s).reverse().toString();
    }

    public static void main(String[] args) {
        N_2744_FindMaximumNumberStringPairs pairs = new N_2744_FindMaximumNumberStringPairs();
        String[] a = {"cd","ac","dc","ca","zz"};
        System.out.println(pairs.maximumNumberOfStringPairs(a));
    }
}
