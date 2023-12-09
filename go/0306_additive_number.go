package main

import (
	"strconv"
	"strings"
)

func isAdditiveNumber(num string) bool {
	var dfs func(sub string, f, s int) bool
	dfs = func(sub string, f, s int) bool {
		if sub == "" {
			return true
		}
		next := strconv.Itoa(f + s)
		if strings.HasPrefix(sub, next) {
			if dfs(sub[len(next):], s, f+s) {
				return true
			}
		}
		return false
	}

	for i := 1; i < len(num)-1; i++ {
		if num[0:i][0] == '0' && len(num[0:i]) > 1 {
			break
		}
		for j := i + 1; j < len(num); j++ {
			if num[i:j][0] == '0' && len(num[i:j]) > 1 {
				break
			}
			f, _ := strconv.Atoi(num[0:i])
			s, _ := strconv.Atoi(num[i:j])
			if dfs(num[j:], f, s) {
				return true
			}
		}
	}
	return false
}
