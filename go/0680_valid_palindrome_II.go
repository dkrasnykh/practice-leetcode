package main

func isValid(s string, l, r int) bool {
	for l < r {
		if s[l] != s[r] {
			return false
		}
		l += 1
		r -= 1
	}
	return true
}

func validPalindrome(s string) bool {
	l, r := 0, len(s)-1
	for l < r {
		if s[l] != s[r] {
			return isValid(s, l, r-1) || isValid(s, l+1, r)
		}
		l += 1
		r -= 1
	}
	return true
}
