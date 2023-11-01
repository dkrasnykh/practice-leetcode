package tries.design_add_and_search_words_data_structure_211;

import java.util.ArrayDeque;

class WordDictionary {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;

        TrieNode() {
        }
    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }


    public boolean search(String word) {
        TrieNode curr = root;
        ArrayDeque<TrieNode> q = new ArrayDeque<>();
        q.addLast(curr);
        for (char c : word.toCharArray()) {
            int size = q.size();
            if (c == '.') {
                while (size > 0) {
                    TrieNode node = q.pollFirst();
                    for (TrieNode child : node.children) {
                        if (child != null) {
                            q.addLast(child);
                        }
                    }
                    size -= 1;
                }
            } else {
                boolean found = false;
                while (size > 0) {
                    TrieNode node = q.pollFirst();
                    if (node.children[c - 'a'] != null) {
                        found = true;
                        q.addLast(node.children[c - 'a']);
                    }
                    size -= 1;
                }
                if (!found) {
                    return false;
                }
            }
        }
        while (!q.isEmpty()) {
            if (q.pollFirst().isEndOfWord) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("book");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..k")); // return True
    }
}
