package main

func countSubstrings(s string) int {
	cnt := 0
	for i := 0; i < len(s); i++ {
		l, r := i, i+1
		for l >= 0 && r < len(s) {
			if s[l] == s[r] {
				l -= 1
				r += 1
				cnt += 1
			} else {
				break
			}
		}
		cnt += 1
		l, r = i-1, i+1
		for l >= 0 && r < len(s) {
			if s[l] == s[r] {
				l -= 1
				r += 1
				cnt += 1
			} else {
				break
			}
		}
	}
	return cnt
}

/*
//https://neetcode.io/practice
func countSubstrings(s string) int {
	n := len(s)
	pal := func(l, r int) int {
		count := 0
		for l >= 0 && r < n && s[l] == s[r] {
			count++
			l--
			r++
		}
		return count
	}

	count := 0
	for i := range s {
		count += pal(i, i)
		count += pal(i, i+1)
	}
	return count
}
*/
