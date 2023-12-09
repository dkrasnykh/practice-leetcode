package main

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	var freq [26]int
	for i := 0; i < len(s); i++ {
		freq[s[i]-'a'] += 1
	}
	for i := 0; i < len(t); i++ {
		freq[t[i]-'a'] -= 1
		if freq[t[i]-'a'] < 0 {
			return false
		}
	}
	return true
}
