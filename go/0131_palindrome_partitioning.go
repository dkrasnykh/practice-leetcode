package main

func partition(s string) [][]string {
	result := make([][]string, 0)
	part := make([]string, 0)
	isPali := func(l, r int) bool {
		for l <= r {
			if s[l] != s[r] {
				return false
			}
			l += 1
			r -= 1
		}
		return true
	}
	var backtrack func(i int)
	backtrack = func(i int) {
		if i >= len(s) {
			result = append(result, append([]string{}, part...))
			return
		}
		for j := i; j < len(s); j++ {
			if isPali(i, j) {
				part = append(part, s[i:j+1])
				backtrack(j + 1)
				part = part[:len(part)-1]
			}
		}
	}
	backtrack(0)
	return result
}
