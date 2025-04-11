package org.example.implementations;

import java.util.HashMap;

public class N_13_RomanToInteger {
    HashMap<Character, Integer> map = new HashMap<>();

    public int romanToInt(String s) {
        buildMap();
        int result = 0;
        int prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = map.get(s.charAt(i));
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }

    public void buildMap(){
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}

/*
class Solution {
    public int romanToInt(String s)
    {
        int l = s.length();
        int[] arr = new int[l];
        for(int i = 0; i < l; i++)
        {
            switch (s.charAt(i))
            {
                case 'I':
                    arr[i] = 1;
                    break;
                case 'V':
                    arr[i] = 5;
                    break;
                case 'X':
                    arr[i] = 10;
                    break;
                case 'L':
                    arr[i] = 50;
                    break;
                case 'C':
                    arr[i] = 100;
                    break;
                case 'D':
                    arr[i] = 500;
                    break;
                case 'M':
                    arr[i] = 1000;
                    break;

            }
        }
        int sum = 0;
        for (int i = 0; i < l; i++)
        {
            if (i < l - 1 && arr[i] < arr[i + 1])
            {
                sum -= arr[i];
                i++;
            }
            sum += arr[i];
        }
        return sum;
    }
}
 */