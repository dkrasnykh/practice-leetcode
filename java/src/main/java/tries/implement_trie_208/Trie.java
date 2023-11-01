package tries.implement_trie_208;

class Trie {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); ++i) {
            int j = word.charAt(i) - 'a';
            if (curr.children[j] == null) {
                curr.children[j] = new TrieNode();
            }
            curr = curr.children[j];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); ++i) {
            int j = word.charAt(i) - 'a';
            if (curr.children[j] == null) {
                return false;
            }
            curr = curr.children[j];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int j = prefix.charAt(i) - 'a';
            if (curr.children[j] == null) {
                return false;
            }
            curr = curr.children[j];
        }
        return true;
    }
}
