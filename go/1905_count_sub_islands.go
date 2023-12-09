package main

func countSubIslands(grid1 [][]int, grid2 [][]int) int {
	m, n := len(grid1), len(grid1[0])
	d := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	var dfs func(r, c int) bool
	dfs = func(r, c int) bool {
		if r < 0 || r == m || c < 0 || c == n || grid2[r][c] == 0 {
			return true
		}
		var res bool = (grid1[r][c] == grid2[r][c])
		grid2[r][c] = 0
		for _, v := range d {
			tmp := dfs(r+v[0], c+v[1])
			res = res && tmp
		}
		return res
	}
	subs := 0
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid2[i][j] == 1 && dfs(i, j) {
				subs += 1
			}
		}
	}
	return subs
}

/*
func main() {

	// grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]

	grid1 := [][]int{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}}
	grid2 := [][]int{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}}
	fmt.Println(countSubIslands(grid1, grid2))
}
*/
