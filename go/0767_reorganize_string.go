package main

import (
	"container/heap"
)

type Heap767 [][2]int

func (h Heap767) Len() int { return len(h) }
func (h Heap767) Less(i, j int) bool {
	if h[i][0] == h[j][0] {
		return h[i][1] < h[j][1]
	} else {
		return h[i][0] > h[j][0]
	}

}
func (h Heap767) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *Heap767) Push(x any) {
	*h = append(*h, x.([2]int))
}

func (h *Heap767) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func reorganizeString(s string) string {
	m := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		m[s[i]] += 1
	}

	h := &Heap767{}
	heap.Init(h)
	for k, v := range m {
		heap.Push(h, [2]int{v, int(k)})
	}
	res := make([]byte, 0, len(s))
	q := make([][3]int, 0)
	ord := 0
	for len(*h) > 0 || len(q) > 0 {
		if len(q) > 0 && q[0][0] == ord {
			f := q[0]
			q = q[1:]
			heap.Push(h, [2]int{f[1], f[2]})
		}
		if len(*h) > 0 {
			f := heap.Pop(h).([2]int)
			res = append(res, byte(f[1]))
			f[0] -= 1
			if f[0] > 0 {
				q = append(q, [3]int{ord + 2, f[0], f[1]})
			}
		}
		ord += 1
	}
	if len(res) > 1 && res[len(res)-1] == res[len(res)-2] {
		return ""
	} else {
		return string(res)
	}
}

/*
func main() {
	fmt.Println(reorganizeString("sfffp"))
}
*/
