package main

func addSolution(result *[][]string, sol []int) {
	n := len(sol)
	tmp := make([]string, len(sol))
	for i := 0; i < n; i++ {
		line := make([]rune, n)
		for j := 0; j < n; j++ {
			if sol[i] == j {
				line[j] = 'Q'
			} else {
				line[j] = '.'
			}
		}
		tmp[i] = string(line)
	}
	*result = append(*result, tmp)
}

func dfs(ind int, n int,
	result *[][]string,
	sol []int,
	rows map[int]struct{},
	cols map[int]struct{},
	diag1 map[int]struct{},
	diag2 map[int]struct{}) {
	//map[string]struct{} - множество
	if len(sol) == n {
		addSolution(result, sol)
		return
	}
	//if _, ok := inputSet[v]; !ok {
	//delete(m, k)
	for j := 0; j < n; j++ {
		_, ok1 := rows[ind]
		_, ok2 := cols[j]
		_, ok3 := diag1[ind-j]
		_, ok4 := diag2[ind+j]
		if !ok1 && !ok2 && !ok3 && !ok4 {
			sol = append(sol, j)
			rows[ind] = struct{}{}
			cols[j] = struct{}{}
			diag1[ind-j] = struct{}{}
			diag2[ind+j] = struct{}{}
			dfs(ind+1, n, result, sol, rows, cols, diag1, diag2)
			sol = sol[:len(sol)-1]
			delete(rows, ind)
			delete(cols, j)
			delete(diag1, ind-j)
			delete(diag2, ind+j)
		}
	}
}

func solveNQueens(n int) [][]string {
	result := make([][]string, 0)
	dfs(0, n, &result, make([]int, 0), make(map[int]struct{}, n), make(map[int]struct{}, n), make(map[int]struct{}, n), make(map[int]struct{}, n))
	return result
}

func main() {
}
