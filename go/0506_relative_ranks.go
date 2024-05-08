package main

import (
	"sort"
	"strconv"
)

func findRelativeRanks(score []int) []string {
	n := len(score)
	tmp := make([]int, n)
	copy(tmp, score)
	sort.Slice(tmp, func(i, j int) bool {
		return tmp[i] > tmp[j]
	})

	m := make(map[int]string, n)
	for i := 0; i < n; i++ {
		switch i {
		case 0:
			m[tmp[i]] = "Gold Medal"
		case 1:
			m[tmp[i]] = "Silver Medal"
		case 2:
			m[tmp[i]] = "Bronze Medal"
		default:
			m[tmp[i]] = strconv.Itoa(i + 1)
		}
	}
	ans := make([]string, n)
	for i := 0; i < n; i++ {
		ans[i] = m[score[i]]
	}
	return ans
}
