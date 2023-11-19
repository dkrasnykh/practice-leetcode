package main

func exist(board [][]byte, word string) bool {
	m := len(board)
	n := len(board[0])
	var backtrack func(r, c, i int) bool
	backtrack = func(r, c, i int) bool {
		if r < 0 || c < 0 || r == m || c == n || i == len(word) || board[r][c] != word[i] {
			return false
		}
		if i == len(word)-1 && board[r][c] == word[i] {
			return true
		}
		tmp := board[r][c]
		board[r][c] = '*'
		res := backtrack(r, c+1, i+1) || backtrack(r, c-1, i+1) || backtrack(r+1, c, i+1) || backtrack(r-1, c, i+1)
		board[r][c] = tmp
		return res
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if backtrack(i, j, 0) {
				return true
			}
		}
	}
	return false
}
