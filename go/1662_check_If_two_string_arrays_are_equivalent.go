package main

func arrayStringsAreEqual(word1 []string, word2 []string) bool {
	w1, w2 := make([]byte, 0), make([]byte, 0)
	for _, s := range word1 {
		w1 = append(w1, s...)
	}
	for _, s := range word2 {
		w2 = append(w2, s...)
	}
	if len(w1) != len(w2) {
		return false
	}
	for i := 0; i < len(w1); i++ {
		if w1[i] != w2[i] {
			return false
		}
	}
	return true
}
