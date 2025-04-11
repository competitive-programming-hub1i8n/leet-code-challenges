package org.example.implementations;

public class N_2315_CountAsterisks {
    public int countAsterisks(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '|'){
                int j = i+1;
                while (s.charAt(j) != '|'){
                    j++;
                }
                i = j;
            }
            if (s.charAt(i) == '*'){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N_2315_CountAsterisks countAsterisks = new N_2315_CountAsterisks();
        System.out.println(countAsterisks.countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(countAsterisks.countAsterisks("iamprogrammer"));
        System.out.println(countAsterisks.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
        System.out.println(countAsterisks.countAsterisks("***"));
    }
}
/*
class Solution {
    public int countAsterisks(String s) {
        int count = 0;
        boolean bar = false;

        for (char c : s.toCharArray()) {
            if (c == '|') {

                bar = !bar;
            } else if (c == '*' && !bar) {

                count++;
            }
        }

        return count;
    }
}
 */
