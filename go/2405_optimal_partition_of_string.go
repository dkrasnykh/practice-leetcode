package main

func partitionString(s string) int {
	res := 1
	set := map[byte]bool{}
	for i := 0; i < len(s); i++ {
		if set[s[i]] {
			res += 1
			set = map[byte]bool{}
		}
		set[s[i]] = true
	}
	return res
}
