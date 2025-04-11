package org.example.implementations;

import java.util.*;

public class BackTracking {
    public static void main(String[] args) {
        System.out.println(new BackTracking().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new BackTracking().findSubstring("barfoofoobar", new String[]{"bar","foo",}));
        System.out.println(new BackTracking().findSubstring("pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel", new String[]{"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"}));

    }

    public List<Integer> findSubstring(String s, String[] words) {
        AhoCorasick aho = new AhoCorasick();
        List<String> permutations = generatePermutations(words);
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < permutations.size(); i++) {
            aho.insert(permutations.get(i), i);
        }
        return aho.search(s);
    }

    static List<String> generatePermutations(String[] words) {
        List<String> permutations = new ArrayList<>();

        build(words, 0, permutations);
        System.out.println(permutations);
        return permutations;
    }

    static void build(String[] words, int start, List<String> permutations){
        if (start == words.length){
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word);
            }
            permutations.add(sb.toString());
            return;
        }

        for (int i = start; i < words.length; i++) {
            swap(words, start, i);
            build(words, start + 1, permutations);
            swap(words, start, i);
        }
    }

    static void swap(String[] words, int i, int j){
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        List<Integer> patterns;

        TrieNode() {
            isEndOfWord = false;
            patterns = new ArrayList<>();
        }
    }

    static class AhoCorasick {
        private TrieNode root;

        AhoCorasick() {
            root = new TrieNode();
        }

        void insert(String word, int patternIndex) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
            current.patterns.add(patternIndex);
        }

        List<Integer> search(String text) {
            TrieNode current = root;
            List<Integer> matches = new ArrayList<>();

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                int index = c - 'a';

                while (current != root && !(current.children[index] == null)) {
                    current = current.children[index];
                }

                if (current.children[index] != null) {
                    current = current.children[index];
                    if (current.isEndOfWord) {
                        matches.addAll(current.patterns);
                    }
                }
            }

            return matches;
        }
    }

}
