package main

type TrieNode struct {
	children    map[byte]*TrieNode
	isEndOfWord bool
}

type Trie struct {
	root *TrieNode
}

func Constructor10() Trie {
	return Trie{
		root: &TrieNode{
			children: make(map[byte]*TrieNode),
		},
	}
}

func (this *Trie) Insert(word string) {
	curr := this.root
	for i := 0; i < len(word); i++ {
		w := word[i]
		if curr.children[w] == nil {
			curr.children[w] = &TrieNode{children: make(map[byte]*TrieNode)}
		}
		curr = curr.children[w]
	}
	curr.isEndOfWord = true
}

func (this *Trie) Search(word string) bool {
	curr := this.root
	for i := 0; i < len(word); i++ {
		w := word[i]
		if curr.children[w] == nil {
			return false
		}
		curr = curr.children[w]
	}
	return curr.isEndOfWord
}

func (this *Trie) StartsWith(prefix string) bool {
	curr := this.root
	for i := 0; i < len(prefix); i++ {
		w := prefix[i]
		if curr.children[w] == nil {
			return false
		}
		curr = curr.children[w]
	}
	return true
}
