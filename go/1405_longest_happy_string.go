package main

import "container/heap"

type MaxPairHeap [][]int

func (h MaxPairHeap) Len() int { return len(h) }
func (h MaxPairHeap) Less(i, j int) bool {
	if h[i][0] == h[j][0] {
		return h[i][1] < h[j][1]
	} else {
		return h[i][0] > h[j][0]
	}
}
func (h MaxPairHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *MaxPairHeap) Push(x any) {
	*h = append(*h, x.([]int))
}

func (h *MaxPairHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func longestDiverseString(a int, b int, c int) string {
	res := make([]byte, 0)
	total := a + b + c
	h := &MaxPairHeap{}
	heap.Init(h)
	for _, v := range [][]int{{a, 'a'}, {b, 'b'}, {c, 'c'}} {
		if v[0] != 0 {
			heap.Push(h, v)
		}
	}
	var prev []int
	for len(*h) > 0 || prev != nil {
		if len(*h) == 0 && prev != nil {
			return string(res)
		}
		curr := heap.Pop(h).([]int)
		if curr[0]/max(1, (total-curr[0])) >= 2 {
			res = append(res, byte(curr[1]))
			total -= 1
			curr[0] -= 1
		}
		res = append(res, byte(curr[1]))
		total -= 1
		curr[0] -= 1

		if prev != nil {
			heap.Push(h, prev)
			prev = nil
		}
		if curr[0] > 0 {
			prev = curr
		}

	}
	return string(res)
}
