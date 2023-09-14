package array.top_k_frequent_words_692;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int maxFreq = 0;
        Map<String, Integer> cnt = new HashMap<>();
        for (String w : words) {
            cnt.compute(w, (key, val) -> val == null ? 1 : val + 1);
            maxFreq = Math.max(maxFreq, cnt.get(w));
        }
        TreeSet<String>[] freq = new TreeSet[maxFreq + 1];
        for (Map.Entry<String, Integer> e : cnt.entrySet()) {
            int i = e.getValue();
            if (freq[i] == null) {
                freq[i] = new TreeSet<>(Comparator.naturalOrder());
            }
            freq[i].add(e.getKey());
        }
        List<String> result = new ArrayList<>();
        int i = maxFreq;
        while(i > 0 && k > 0){
            if(freq[i] != null){
                for(String e : freq[i]){
                    result.add(e);
                    k -= 1;
                    if(k == 0){
                        break;
                    }
                }
            }
            i -= 1;
        }
        return result;
    }
}
