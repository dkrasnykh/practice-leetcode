package main

import (
	"strconv"
)

// https://www.youtube.com/watch?v=Pzg3bCDY87w
type pair struct {
	lock  string
	turns int
}

func openLock1(deadends []string, target string) int {
	visited := make(map[string]bool)
	for _, w := range deadends {
		visited[w] = true
	}

	children := func(lock string) []string {
		res := make([]string, 0)
		for i := 0; i < 4; i++ {
			n, _ := strconv.Atoi(lock[i : i+1])
			res = append(res, lock[:i]+strconv.Itoa((n+1)%10)+lock[i+1:])
			res = append(res, lock[:i]+strconv.Itoa((n-1+10)%10)+lock[i+1:])
		}
		return res
	}
	if visited["0000"] {
		return -1
	}
	q := make([]pair, 0)
	q = append(q, pair{"0000", 0})
	for len(q) > 0 {
		lock := q[0].lock
		turns := q[0].turns
		q = q[1:]
		if lock == target {
			return turns
		}
		for _, c := range children(lock) {
			if !visited[c] {
				visited[c] = true
				q = append(q, pair{c, turns + 1})
			}
		}
	}
	return -1
}
