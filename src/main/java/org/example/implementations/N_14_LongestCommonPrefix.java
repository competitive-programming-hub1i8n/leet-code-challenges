package org.example.implementations;

public class N_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < len; i++) {
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() -1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }


    public static void main(String[] args) {
        N_14_LongestCommonPrefix commonPrefix = new N_14_LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
