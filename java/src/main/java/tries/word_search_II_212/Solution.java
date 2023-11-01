package tries.word_search_II_212;

import java.util.*;

public class Solution {
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
        public void addWord(String w){
            TrieNode curr = this;
            for (char c : w.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.isEndOfWord = true;
        }
    }

    private TrieNode root;

    private int[][] dif = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void contains(int r, int c, char[][] board, TrieNode node, StringBuilder sb, Set<String> res, boolean[][] used) {
        if (r < 0 ||
                r == board.length ||
                c < 0 ||
                c == board[0].length ||
                used[r][c] ||
                !node.children.containsKey(board[r][c])) {
            return;
        }
        for (int[] d : dif) {
            sb.append(board[r][c]);
            used[r][c] = true;
            if (node.children.get(board[r][c]).isEndOfWord) {
                res.add(sb.toString());
            }
            contains(r + d[0], c + d[1], board, node.children.get(board[r][c]), sb, res, used);
            used[r][c] = false;
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String w : words) {
            root.addWord(w);
        }
        Set<String> tmp = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                boolean[][] used = new boolean[board.length][board[0].length];
                contains(i, j, board, root, new StringBuilder(), tmp, used);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        //char[][] board = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        //String[] words = {"oa", "oaa"};
        Solution s = new Solution();
        List<String> result = s.findWords(board, words);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
