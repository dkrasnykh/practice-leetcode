package main

func firstUniqChar(s string) int {
	set := map[byte]int{}
	for i := 0; i < len(s); i++ {
		set[s[i]] += 1
	}
	for i := 0; i < len(s); i++ {
		if set[s[i]] == 1 {
			return i
		}
	}
	return -1
}
