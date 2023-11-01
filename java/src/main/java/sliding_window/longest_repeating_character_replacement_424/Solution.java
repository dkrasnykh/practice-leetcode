package sliding_window.longest_repeating_character_replacement_424;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "{" + first + ", " + second + '}';
        }
    }

    public int characterReplacement(String s, int k) {
        List<Pair>[] subs = new List[26];
        for (int i = 0; i < 26; ++i) {
            subs[i] = new ArrayList<>();
            int start = -1;
            char letter = (char) ((int) 'A' + i);
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == letter && start == -1) {
                    start = j;
                } else if (j > 0 && s.charAt(j) != letter && s.charAt(j - 1) == letter) {
                    subs[i].add(new Pair(start, j - 1));
                    start = -1;
                }
            }
            if (start != -1) {
                subs[i].add(new Pair(start, s.length() - 1));
            }
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            if (subs[i].size() == 0) {
                continue;
            }
            int maxLen = 0;
            int l = 0;
            int r = 0;
            int tail = 0;
            int tmp_k = k;
            int lenght = 0;
            for (l = 0; l < subs[i].size(); ++l) {
                if (l==0 || l > r) {
                    lenght = subs[i].get(l).second - subs[i].get(l).first + 1;
                    tail = 0;
                    tmp_k = k;
                    r=l;
                }
                while (r < subs[i].size() - 1 && tmp_k >= subs[i].get(r + 1).first - subs[i].get(r).second - 1) {
                    lenght += subs[i].get(r + 1).first - subs[i].get(r).second - 1;
                    tmp_k -= subs[i].get(r + 1).first - subs[i].get(r).second - 1;
                    lenght += subs[i].get(r + 1).second - subs[i].get(r + 1).first + 1;
                    r += 1;
                }
                tail = tmp_k;
                lenght += tail;
                maxLen = Math.max(maxLen, lenght);
                lenght -= subs[i].get(l).second - subs[i].get(l).first + 1;
                lenght -= tail;
                if (r > l) {
                    lenght -= subs[i].get(l + 1).first - subs[i].get(l).second - 1;
                    tmp_k += subs[i].get(l + 1).first - subs[i].get(l).second - 1;
                }
            }
            res = Math.max(res, maxLen);
        }
        return Math.min(s.length(), res);
    }

    public static void main(String[] args) {
        //Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());

        Map<String, String> map = new HashMap<>();



        StringBuilder sb = new StringBuilder();


        String email = "test@leetcode.com";
        System.out.println(email.indexOf('@')); //4

        System.out.println(Instant.ofEpochMilli(1692625420844L));

        System.out.println(System.currentTimeMillis());
        //System.out.println(new Date(1692618609660L));
        Solution s = new Solution();
        System.out.println(s.characterReplacement("ABAB", 2));
        System.out.println(s.characterReplacement("AABABBA", 1));
        System.out.println(s.characterReplacement("ABAA", 0));
        //"IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR"  k=2; ans is 6
        System.out.println(s.characterReplacement("IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR", 2));
    }
}
