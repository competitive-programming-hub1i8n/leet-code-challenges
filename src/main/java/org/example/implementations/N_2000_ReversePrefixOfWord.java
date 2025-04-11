package org.example.implementations;

import java.util.Stack;

public class N_2000_ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        int index = word.indexOf(ch);
        if (index == -1){
            return word;
        }
        for (Character i: word.substring(0, index + 1).toCharArray()){
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.append(word.substring(index + 1));
        return sb.toString();
    }
}
