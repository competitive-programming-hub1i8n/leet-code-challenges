package org.example.implementations;

public class N_6_ZigzagConversion {
    public static void main(String[] args) {
        N_6_ZigzagConversion obj = new N_6_ZigzagConversion();
        System.out.println(obj.convert("PAYPALISHIRING", 3));
        // P A Y P A L I S H I R  I  N  G
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13
        // P A H N A L I G Y I R P S I A H N
        // P A H N A P L S I I G Y I R

        /*
            P     A     H     N
            A  P  L  S  I  I  G
            Y     I     R
         */
    }

    public String convert(String s, int numRows) {

        int n = s.length();
        int cycle = 2 * numRows - 2;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i += cycle) builder.append(s.charAt(i));


        for (int r = 1; r < numRows - 1; ++r){
            int step1 = r;
            boolean toggle = false;
            while (step1 < n) {
                builder.append(s.charAt(step1));
                int step2 = (!toggle) ? (cycle - 2 * r) : (2 * r);
                step1 += step2;
                toggle = !toggle;
            }
        }
        for (int i = numRows - 1; i < n; i += cycle) builder.append(s.charAt(i));

        return builder.toString();
    }
}
