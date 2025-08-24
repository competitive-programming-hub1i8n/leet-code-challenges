package org.example.implementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_679_24_Game {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(",");
        int[] cards = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }
        System.out.println(new N_679_24_Game().judgePoint24(cards));
    }

    public boolean judgePoint24(int[] cards) {

        return true;
    }
}
