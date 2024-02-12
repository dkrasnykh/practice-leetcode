package main

func longestPalindrome(s string) string {
	var result string
	for i := 0; i < len(s); i++ {
		//aba
		//aa
		l, r := i, i+1
		for l >= 0 && r < len(s) {
			if s[l] == s[r] {
				l -= 1
				r += 1
			} else {
				break
			}
		}
		//0123
		//caab
		if r-l-1 > len(result) {
			result = s[l+1 : r]
		}
		l, r = i-1, i+1
		for l >= 0 && r < len(s) {
			if s[l] == s[r] {
				l -= 1
				r += 1
			} else {
				break
			}
		}
		if r-l-1 > len(result) {
			result = s[l+1 : r]
		}
	}
	return result
}
