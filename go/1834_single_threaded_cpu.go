package main

import (
	"container/heap"
	"sort"
)

type Heap2 [][3]int

func (h Heap2) Len() int { return len(h) }
func (h Heap2) Less(i, j int) bool {
	if h[i][1] == h[j][1] {
		return h[i][2] < h[j][2]
	} else {
		return h[i][1] < h[j][1]
	}
}
func (h Heap2) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *Heap2) Push(x any) {
	*h = append(*h, x.([3]int))
}

func (h *Heap2) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func getOrder(tasks [][]int) []int {
	q := make([][3]int, len(tasks))
	for i := 0; i < len(tasks); i++ {
		q[i] = [3]int{tasks[i][0], tasks[i][1], i}
	}
	sort.Slice(q, func(i, j int) bool {
		if q[i][0] == q[j][0] {
			if q[i][1] == q[j][1] {
				return q[i][2] < q[j][2]
			} else {
				return q[i][1] < q[j][1]
			}
		} else {
			return q[i][0] < q[j][0]
		}
	})
	result := make([]int, 0)
	h := &Heap2{}
	heap.Init(h)
	start := -1
	for len(q) > 0 || len(*h) > 0 {
		var curr [3]int
		if len(*h) == 0 {
			curr = q[0]
			q = q[1:]
		} else {
			curr = heap.Pop(h).([3]int)
		}
		start = max(start, curr[0])
		result = append(result, curr[2])
		for len(q) > 0 && start+curr[1] >= q[0][0] {
			heap.Push(h, q[0])
			q = q[1:]
		}
		start += curr[1]
	}
	return result
}

/*
func main() {
	//tasks := [][]int{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}}
	tasks := [][]int{{5, 2}, {7, 2}, {9, 4}, {6, 3}, {5, 10}, {1, 1}}
	fmt.Println(getOrder(tasks))
}
*/
