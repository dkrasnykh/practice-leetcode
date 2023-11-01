package two_pointers.compare_version_numbers_165;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Integer> parse(String s) {
        s = s.concat(".");
        List<Integer> result = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '.') {
                result.add(Integer.parseInt(s.substring(i - length, i)));
                length = 0;
            } else {
                length += 1;
            }
        }
        return result;
    }

    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = parse(version1);
        List<Integer> v2 = parse(version2);
        int i = 0;
        int size = Math.min(v1.size(), v2.size());
        while (i < size) {
            if (v1.get(i).compareTo(v2.get(i)) != 0) {
                return v1.get(i).compareTo(v2.get(i));
            }
            i += 1;
        }
        while (i < v1.size()) {
            if (v1.get(i) != 0) {
                return 1;
            }
            i += 1;
        }
        while (i < v2.size()) {
            if (v2.get(i) != 0) {
                return -1;
            }
            i += 1;
        }
        return 0;
    }
}
