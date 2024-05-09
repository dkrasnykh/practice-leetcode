package main

import "sort"

func maximumHappinessSum(happiness []int, k int) int64 {
	sort.Slice(happiness, func(i, j int) bool {
		return happiness[i] > happiness[j]
	})

	var ans int64
	for i := 0; i < k; i++ {
		ans += int64(max(0, happiness[i]-i))
	}

	return ans
}
