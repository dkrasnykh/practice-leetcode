package main

import "container/heap"

func longestDiverseString1(a int, b int, c int) string {
	res := make([]byte, 0)
	h := &MaxPairHeap{}
	heap.Init(h)
	for _, v := range [][]int{{a, 'a'}, {b, 'b'}, {c, 'c'}} {
		if v[0] != 0 {
			heap.Push(h, v)
		}
	}
	for len(*h) > 0 {
		curr := heap.Pop(h).([]int)
		count, char := curr[0], curr[1]
		if len(res) > 1 && res[len(res)-1] == res[len(res)-2] && res[len(res)-1] == byte(char) {
			if len(*h) == 0 {
				break
			}
			curr = heap.Pop(h).([]int)
			count2, char2 := curr[0], curr[1]
			res = append(res, byte(char2))
			count2 -= 1
			if count2 > 0 {
				heap.Push(h, []int{count2, char2})
			}
		} else {
			res = append(res, byte(char))
			count -= 1
		}
		if count > 0 {
			heap.Push(h, []int{count, char})
		}
	}
	return string(res)
}
