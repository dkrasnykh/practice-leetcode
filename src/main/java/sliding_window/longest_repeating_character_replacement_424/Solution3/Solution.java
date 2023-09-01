package sliding_window.longest_repeating_character_replacement_424.Solution3;

import java.util.*;

class Pair {
    char c;
    int n;

    public Pair(char c, int n) {
        this.c = c;
        this.n = n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return c == pair.c && n == pair.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, n);
    }
}

public class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        TreeSet<Pair> treeSet = new TreeSet<>((p1,p2)->(p2.n != p1.n) ? p2.n - p1.n : p1.c - p2.c);
        int total = 0, l = 0, totalMax = 0, localMax = 0;
        for(int r = 0; r < s.length(); ++r){
            localMax = (treeSet.isEmpty())?0:treeSet.first().n;
            while(total - localMax > k){
                int ln = map.getOrDefault(s.charAt(l), 0);
                if(ln == 1){
                    treeSet.remove(new Pair(s.charAt(l), ln));
                    map.remove(s.charAt(l));
                } else if (ln > 1){
                    treeSet.remove(new Pair(s.charAt(l), ln));
                    map.compute(s.charAt(l), (key,val)->val-1);
                    treeSet.add(new Pair(s.charAt(l), ln - 1));
                }
                localMax = (treeSet.isEmpty())?0:treeSet.first().n;
                total -= 1;
                l += 1;
            }
            totalMax = Math.max(totalMax, total);
            int rn = map.getOrDefault(s.charAt(r), 0);
            if(rn != 0){
                treeSet.remove(new Pair(s.charAt(r), rn));
            }
            map.put(s.charAt(r), rn + 1);
            treeSet.add(new Pair(s.charAt(r), rn + 1));
            total += 1;
        }
        localMax = (treeSet.isEmpty())?0:treeSet.first().n;
        if(total -localMax <= k){
            totalMax = Math.max(totalMax, total);
        }
        return totalMax;
    }
}
