package org.example.implementations;
import java.util.*;
public class N_2682_FindTheLosersOfTheCircularGame {
    public int[] circularGameLosers(int n, int k) {
        boolean[] freq = new boolean[n];
        int i = 0;
        int currentFriend = 1;

        while(!freq[i % n]) {
            int lastFriend = getLastFriend(currentFriend, k);
            freq[i % n] = true;
            i += lastFriend;
            currentFriend++;
        }
        int[] losers = new int[(n - currentFriend) + 1];
        int index = 0;
        for (int j = 0; j < n; j++) {
            if(!freq[j]) {
                losers[index] = j+1;
                index++;
            }
        }

        return losers;
    }

    public int getLastFriend(int current, int k){
        return current * k;
    }

    public static void main(String[] args) {
        N_2682_FindTheLosersOfTheCircularGame game = new N_2682_FindTheLosersOfTheCircularGame();
        int[] freq = game.circularGameLosers(5, 2);
        System.out.println(Arrays.toString(freq));

        freq = game.circularGameLosers(4, 4);
        System.out.println(Arrays.toString(freq));
    }
}
