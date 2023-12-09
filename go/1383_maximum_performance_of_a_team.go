package main

import (
	"container/heap"
	"sort"
)

func maxPerformance(n int, speed []int, efficiency []int, k int) int {
	quality := make([][2]int, len(speed))
	for i := 0; i < len(speed); i++ {
		quality[i] = [2]int{speed[i], efficiency[i]}
	}
	sort.Slice(quality, func(i, j int) bool {
		if quality[i][1] == quality[j][1] {
			return quality[i][0] > quality[j][0]
		} else {
			return quality[i][1] > quality[j][1]
		}
	})
	mod := 1000000007
	h := &IntHeap{}
	heap.Init(h)
	currSum := 0
	ans := 0
	for i := 0; i < n; i++ {
		currSum += quality[i][0]
		heap.Push(h, quality[i][0])
		ans = max(ans, currSum*quality[i][1])
		if i >= k-1 {
			f := heap.Pop(h).(int)
			currSum -= f
		}
	}
	return ans % mod
}
