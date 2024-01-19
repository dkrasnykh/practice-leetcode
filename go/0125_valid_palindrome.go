package main

import "unicode"

func isPalindrome(s string) bool {
	isAlphanumeric := func(c rune) bool {
		return unicode.IsLetter(c) || unicode.IsDigit(c)
	}
	l, r := 0, len(s)-1
	rns := []rune(s)
	for l < r {
		left := unicode.ToLower(rns[l])
		right := unicode.ToLower(rns[r])

		if !isAlphanumeric(left) {
			l += 1
		} else if !isAlphanumeric(right) {
			r -= 1
		} else if left != right {
			return false
		} else {
			l += 1
			r -= 1
		}
	}
	return true
}
