package org.example.implementations;

import java.util.Map;
import java.util.Stack;

public class N_20_ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> m = Map.of(
                ')','(',
                '}','{',
                ']','['
        );
        Stack<Character> c = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!c.isEmpty() && c.peek() == m.get(s.charAt(i))){
                c.pop();
            }else {
                c.push(s.charAt(i));
            }
        }

        return c.isEmpty();
    }
}
