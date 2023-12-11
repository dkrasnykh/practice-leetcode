package main

func transpose(matrix [][]int) [][]int {
	m := len(matrix)
	n := len(matrix[0])
	result := make([][]int, n)
	for i := 0; i < n; i++ {
		result[i] = make([]int, m)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			result[j][i] = matrix[i][j]
		}
	}
	return result
}
