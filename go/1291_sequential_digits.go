package main

import "strconv"

func sequentialDigits(low int, high int) []int {
	s := "123456789"
	l, r := len(strconv.Itoa(low)), max(len(strconv.Itoa(high)), len(s))
	result := []int{}
	for w := l; w <= r; w++ {
		i := w - 1
		for i < len(s) {
			sub := s[i-w+1 : i+1]
			n, _ := strconv.Atoi(sub)
			if n >= low && n <= high {
				result = append(result, n)
			}
			i += 1
		}
	}
	return result
}
