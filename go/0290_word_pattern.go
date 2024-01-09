package main

import "fmt"

func wordPattern(pattern string, s string) bool {
	s += ` `
	words, space := make([]string, 0), -1
	for i := 0; i < len(s); i++ {
		if s[i] == ' ' {
			words = append(words, s[space+1:i])
			space = i
		}
	}
	m1 := make(map[byte]string)
	m2 := make(map[string]byte)
	if len(pattern) != len(words) {
		return false
	}
	for i := 0; i < len(pattern); i++ {
		v1, ok1 := m1[pattern[i]]
		v2, ok2 := m2[words[i]]
		if ok1 && !ok2 || !ok1 && ok2 || ok1 && ok2 && (v1 != words[i] || v2 != pattern[i]) {
			return false
		}
		m1[pattern[i]] = words[i]
		m2[words[i]] = pattern[i]
	}
	return true
}

func main() {
	fmt.Println(wordPattern(`abba`, `dog cat cat dog`))
}
