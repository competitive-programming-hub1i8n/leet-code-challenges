package org.example.implementations;

public class N_2278_PercentageLetterString {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        int n = s.length();
        int p1 = 0, p2 = n-1;
        while (p1 <= p2){
            if (s.charAt(p1) == letter || s.charAt(p2) == letter){
                count++;
            }
            p1++;
            p2--;
        }
        System.out.println(count);
        System.out.println((count / n));
        return getPercentage(count, n);
    }

    static int getPercentage(int amount, int totalLetters) {

        return 0;
    }

    public static void main(String[] args) {
        N_2278_PercentageLetterString test = new N_2278_PercentageLetterString();
        test.percentageLetter("sgawtb", 's');
        test.percentageLetter("foobar", 'o');
    }
}
