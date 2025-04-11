package org.example.implementations;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        String prefix = strs[0].substring(0, 1);
        int slicing = 1;
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].startsWith(prefix)){
                if (strs[i].startsWith(prefix)){
                    result = prefix;
                    prefix = strs[i].substring(0, slicing++);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
