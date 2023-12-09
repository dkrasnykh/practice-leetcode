package main

import "container/heap"

type Heap7671 [][]int

func (h Heap7671) Len() int { return len(h) }
func (h Heap7671) Less(i, j int) bool {
	if h[i][0] == h[j][0] {
		return h[i][1] < h[j][1]
	} else {
		return h[i][0] > h[j][0]
	}

}
func (h Heap7671) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *Heap7671) Push(x any) {
	*h = append(*h, x.([]int))
}

func (h *Heap7671) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func reorganizeString1(s string) string {
	m := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		m[s[i]] += 1
	}
	h := &Heap7671{}
	heap.Init(h)
	for k, v := range m {
		heap.Push(h, []int{v, int(k)})
	}
	var prev []int
	res := make([]byte, 0, len(s))
	for len(*h) > 0 || prev != nil {
		if prev != nil && len(*h) == 0 {
			return ""
		}
		f := heap.Pop(h).([]int)
		cnt, char := f[0], f[1]
		res = append(res, byte(char))
		cnt -= 1

		if prev != nil {
			heap.Push(h, prev)
			prev = nil
		}
		if cnt != 0 {
			prev = []int{cnt, char}
		}
	}
	return string(res)
}
