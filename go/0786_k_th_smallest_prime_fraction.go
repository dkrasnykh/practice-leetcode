package main

import "container/heap"

type Pair1 struct {
	x int
	y int
}

type PairHeap []Pair1

func (h PairHeap) Len() int { return len(h) }
func (h PairHeap) Less(i, j int) bool {
	return float64(h[i].x)/float64(h[i].y) < float64(h[j].x)/float64(h[j].y)
}
func (h PairHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *PairHeap) Push(x any) {
	*h = append(*h, x.(Pair1))
}

func (h *PairHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func kthSmallestPrimeFraction(arr []int, k int) []int {
	h := &PairHeap{}
	heap.Init(h)
	for i := 0; i < len(arr)-1; i++ {
		for j := i + 1; j < len(arr); j++ {
			heap.Push(h, Pair1{arr[i], arr[j]})
		}
	}

	var ans Pair1
	for k > 0 {
		ans = heap.Pop(h).(Pair1)
		k -= 1
	}

	return []int{ans.x, ans.y}

}
