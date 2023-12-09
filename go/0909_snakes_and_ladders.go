package main

import "fmt"

func snakesAndLadders(board [][]int) int {
	n := len(board)
	a := make([][]int, n)
	curr := 1
	for i := n - 1; i >= 0; i-- {
		a[i] = make([]int, n)
		if (n-i)%2 == 1 {
			for j := 0; j < n; j++ {
				a[i][j] = curr
				curr += 1
			}
		} else {
			for j := n - 1; j >= 0; j-- {
				a[i][j] = curr
				curr += 1
			}
		}
	}
	s := make([][2]int, n*n+1)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			s[a[i][j]] = [2]int{i, j}
		}
	}
	d := make([]int, n*n+1)
	for i := 0; i <= n*n; i++ {
		d[i] = n*n + 2
	}
	q := make([]int, 0)
	q = append(q, 1)
	d[1] = 0
	for len(q) > 0 {
		v := q[0]
		q = q[1:]
		for i := v + 1; i <= min(v+6, n*n); i++ {
			r, c := s[i][0], s[i][1]
			u := 0
			if board[r][c] != -1 {
				u = board[r][c]
			} else {
				u = i
			}
			if d[u] > d[v]+1 {
				d[u] = d[v] + 1
				q = append(q, u)
			}
		}
	}
	if d[n*n] == n*n+2 {
		return -1
	} else {
		return d[n*n]
	}
}

func main() {
	/*
		board := [][]int{{-1, -1, -1, -1, -1, -1},
			{-1, -1, -1, -1, -1, -1},
			{-1, -1, -1, -1, -1, -1},
			{-1, 35, -1, -1, 13, -1},
			{-1, -1, -1, -1, -1, -1},
			{-1, 15, -1, -1, -1, -1}}
	*/
	board := [][]int{{1, 1, -1},
		{1, 1, 1},
		{-1, 1, 1}}
	fmt.Println(snakesAndLadders(board))
}
