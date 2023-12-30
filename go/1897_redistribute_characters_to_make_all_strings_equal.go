package main

func makeEqual(words []string) bool {
	m := make(map[byte]int)
	for _, w := range words {
		for i := 0; i < len(w); i++ {
			m[w[i]] += 1
		}
	}
	n := len(words)
	for _, v := range m {
		if v%n != 0 {
			return false
		}
	}
	return true
}
