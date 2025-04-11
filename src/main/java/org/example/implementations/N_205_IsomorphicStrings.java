package org.example.implementations;

import java.util.HashMap;
import java.util.Map;

public class N_205_IsomorphicStrings {
    public static void main(String[] args){

        //Scanner x = new Scanner(System.in);
        //System.out.println(getFirst("abacabad"));
        System.out.println(getFirst("ababbcc"));
    }
    static String getFirst(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            Character key = str.charAt(i);
            System.out.println(key);
            if(map.containsKey(key)){
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 0);
            }
        }

        System.out.println(map);
        String res = "-";
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                res = entry.getKey()+"";
                break;
            }
        }
        return res == "-" ? "No hay caracteres únicos" : res;
    }
}
