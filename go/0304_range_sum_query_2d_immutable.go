package main

type NumMatrix struct {
	prefix [][]int
}

func Constructor7(matrix [][]int) NumMatrix {
	m, n := len(matrix), len(matrix[0])
	p := make([][]int, m+1)
	p[0] = make([]int, n+1)
	for i := 1; i <= m; i++ {
		p[i] = make([]int, n+1)
		total := 0
		for j := 1; j <= n; j++ {
			total += matrix[i-1][j-1]
			p[i][j] = p[i-1][j] + total
		}
	}
	return NumMatrix{prefix: p}
}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	return this.prefix[row2+1][col2+1] - this.prefix[row1][col2+1] - this.prefix[row2+1][col1] + this.prefix[row1][col1]
}
