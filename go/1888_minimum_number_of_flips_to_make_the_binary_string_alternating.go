package main

import (
	"strings"
)

func minFlips(s string) int {
	n := len(s)
	s = strings.Repeat(s, 2)
	target1 := make([]byte, 0, 2*n)
	target2 := make([]byte, 0, 2*n)
	for i := 0; i < 2*n; i++ {
		if i%2 == 0 {
			target1 = append(target1, '0')
			target2 = append(target2, '1')
		} else {
			target1 = append(target1, '1')
			target2 = append(target2, '0')
		}
	}
	tmp1, tmp2, res := 0, 0, 2*n
	for r := 0; r < 2*n; r++ {
		if r >= n {
			l := r - n
			if s[l] != target1[l] {
				tmp1 -= 1
			}
			if s[l] != target2[l] {
				tmp2 -= 1
			}
		}
		if s[r] != target1[r] {
			tmp1 += 1
		}
		if s[r] != target2[r] {
			tmp2 += 1
		}
		if r >= n {
			res = min(res, min(tmp1, tmp2))
		}
	}
	return res
}
