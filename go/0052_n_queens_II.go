package main

func totalNQueens(n int) int {
	column, diag1, diag2 := make(map[int]int), make(map[int]int), make(map[int]int)
	result := 0
	var backtrack func(y int)
	backtrack = func(y int) {
		if y == n {
			result += 1
		}
		for x := 0; x < n; x++ {
			if column[x] > 0 || diag1[x+y] > 0 || diag2[n+x-y-1] > 0 {
				continue
			}
			column[x], diag1[x+y], diag2[n+x-y-1] = 1, 1, 1
			backtrack(y + 1)
			column[x], diag1[x+y], diag2[n+x-y-1] = 0, 0, 0
		}
	}
	backtrack(0)
	return result
}
