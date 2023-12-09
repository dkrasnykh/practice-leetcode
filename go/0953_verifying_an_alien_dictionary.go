package main

func isAlienSorted(words []string, order string) bool {
	orderInd := make(map[byte]int, 0)
	for i := 0; i < len(order); i++ {
		orderInd[order[i]] = i
	}
	for i := 0; i < len(words)-1; i++ {
		w1, w2 := words[i], words[i+1]
		for j := 0; j < len(w1); j++ {
			if j == len(w2) {
				return false
			}
			if w1[j] != w2[j] {
				if orderInd[w2[j]] < orderInd[w1[j]] {
					return false
				}
				break
			}
		}
	}
	return true
}
