package main

import (
	"strconv"
	"strings"
)

func restoreIpAddresses(s string) []string {
	result := make([]string, 0)
	part := make([]string, 0)

	var backtrack func(ind int)
	backtrack = func(ind int) {
		if len(part) == 3 {
			num, _ := strconv.Atoi(s[ind:])
			if len(s)-ind > 3 || num > 255 {
				return
			}
		}
		if len(part) == 4 && ind < len(s) {
			return
		}
		if len(part) == 4 {
			result = append(result, strings.Join(part, "."))
			return
		}
		for i := ind; i < min(len(s), ind+3); i++ {
			sub := s[ind : i+1]
			num, _ := strconv.Atoi(sub)
			if len(sub) > 1 && sub[0] == '0' || num > 255 {
				return
			}
			part = append(part, sub)
			backtrack(i + 1)
			part = part[:len(part)-1]
		}
	}
	backtrack(0)
	return result
}
