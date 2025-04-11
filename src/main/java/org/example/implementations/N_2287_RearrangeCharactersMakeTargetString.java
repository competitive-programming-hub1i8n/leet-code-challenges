package org.example.implementations;


/**
 * @Name: Rearrange Characters to Make Target String
 * @Number: 2287
 * @Url: <a href="https://leetcode.com/problems/rearrange-characters-to-make-target-string/description/">go to challenge</a>
 */
public class N_2287_RearrangeCharactersMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        int answer = Integer.MAX_VALUE;
        int[] freq = generateFreq(s);
        int[] freq2 = generateFreq(target);
        for(char c : target.toCharArray()){
            answer = Math.min(answer, freq[c - 'a']/freq2[c - 'a']);
        }

        return answer;
    }

    public int[] generateFreq(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        return freq;


    }
}
