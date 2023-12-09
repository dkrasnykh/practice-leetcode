package main

import "container/heap"

type DistHeap [][2]int

func (h DistHeap) Len() int { return len(h) }
func (h DistHeap) Less(i, j int) bool {
	if h[i][0] == h[j][0] {
		return h[i][1] < h[j][1]
	} else {
		return h[i][0] < h[j][0]
	}
}
func (h DistHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *DistHeap) Push(x any) {
	*h = append(*h, x.([2]int))
}

func (h *DistHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func kClosest(points [][]int, k int) [][]int {
	h := &DistHeap{}
	heap.Init(h)
	for i := 0; i < len(points); i++ {
		heap.Push(h, [...]int{points[i][0]*points[i][0] + points[i][1]*points[i][1], i})
	}
	result := make([][]int, 0)
	for k > 0 {
		e := heap.Pop(h).([2]int)
		result = append(result, points[e[1]])
		k -= 1
	}
	return result
}
