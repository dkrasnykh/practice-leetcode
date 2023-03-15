package array.valid_anagram_242;

public class Solution2 {
    public boolean isAnagram(String s, String t) {
        s = s.chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append )
                .toString();
        t = t.chars()
                .sorted()
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append )
                .toString();
        return s.equals(t);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.isAnagram("anagram", "nagaram"));
        //s = "rat", t = "car"
        System.out.println(s.isAnagram("rat", "car"));

    }
}
