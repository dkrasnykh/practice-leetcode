package main

import "strings"

func frequencySort(s string) string {
	size := 0
	max := func(n1, n2 int) int {
		if n1 > n2 {
			return n1
		}
		return n2
	}
	cnt := map[byte]int{}
	for i := 0; i < len(s); i++ {
		cnt[s[i]] += 1
		size = max(size, cnt[s[i]])
	}
	res := []byte{}
	bucket := make([][]byte, size+1)
	for k, v := range cnt {
		bucket[v] = append(bucket[v], k)
	}
	for i := size; i >= 0; i-- {
		for j := 0; j < len(bucket[i]); j++ {
			tmp := string([]byte{bucket[i][j]})
			res = append(res, []byte(strings.Repeat(tmp, i))...)
		}
	}
	return string(res)
}
