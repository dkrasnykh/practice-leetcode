package main

import (
	"container/heap"
	"sort"
)

type MinPairHeap [][]int

func (h MinPairHeap) Len() int { return len(h) }
func (h MinPairHeap) Less(i, j int) bool {
	if h[i][0] == h[j][0] {
		return h[i][1] < h[j][1]
	} else {
		return h[i][0] < h[j][0]
	}
}
func (h MinPairHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *MinPairHeap) Push(x any) {
	*h = append(*h, x.([]int))
}

func (h *MinPairHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func carPooling1(trips [][]int, capacity int) bool {
	sort.Slice(trips, func(i, j int) bool {
		return trips[i][1] < trips[j][1]
	})
	h := &MinPairHeap{}
	heap.Init(h)
	curPass := 0

	for i := 0; i < len(trips); i++ {
		numPass, start, end := trips[i][0], trips[i][1], trips[i][2]
		for len(*h) > 0 {
			tmp := heap.Pop(h).([]int)
			if tmp[0] <= start {
				curPass -= tmp[1]
			} else {
				heap.Push(h, tmp)
				break
			}
		}
		curPass += numPass
		if curPass > capacity {
			return false
		}
		heap.Push(h, []int{end, numPass})
	}
	return true
}
