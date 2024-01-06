package main

import "sort"

func jobScheduling(startTime []int, endTime []int, profit []int) int {
	intervals := make([][3]int, len(startTime))
	for i := 0; i < len(startTime); i++ {
		intervals[i] = [...]int{startTime[i], endTime[i], profit[i]}
	}
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][0] == intervals[j][0] {
			if intervals[i][1] == intervals[j][1] {
				return intervals[i][2] < intervals[j][2]
			}
			return intervals[i][1] < intervals[j][1]
		}
		return intervals[i][0] < intervals[j][0]
	})

	cache := make(map[int]int)

	var dfs func(i int) int
	dfs = func(i int) int {
		if i == len(intervals) {
			return 0
		}
		if v, ok := cache[i]; ok {
			return v
		}

		res := dfs(i + 1)
		j := i + 1
		//можно заменить на бинарный поиск
		for j < len(intervals) {
			if intervals[i][1] <= intervals[j][0] {
				break
			}
			j += 1
		}
		res = max(res, intervals[i][2]+dfs(j))
		cache[i] = res
		return res
	}
	return dfs(0)
}
