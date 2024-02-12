package main

func lengthOfLongestSubstring(s string) int {
	set := map[byte]bool{}
	l, ans := 0, 0
	for r := 0; r < len(s); r++ {
		if set[s[r]] {
			ans = max(ans, r-l)
			for s[l] != s[r] {
				set[s[l]] = false
				l += 1
			}
			set[s[l]] = false
			l += 1
		}
		set[s[r]] = true
	}
	ans = max(ans, len(s)-l)
	return ans
}
