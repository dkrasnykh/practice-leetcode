package main

func findOrder(numCourses int, prerequisites [][]int) []int {
	/*
		1. Построить граф
		2. Строить топологическую сортировку и параллельно проверять на цикл
		3. Если цикл найден, то выводить пустой массив
		2. Если цикл не найден -> строить топологическую сортировку
	*/
	adj := make([][]int, numCourses)
	for i := 0; i < len(prerequisites); i++ {
		adj[prerequisites[i][1]] = append(adj[prerequisites[i][1]], prerequisites[i][0])
	}
	used := make([]int, numCourses)
	ans := make([]int, numCourses)
	i := numCourses - 1

	var dfs func(v int) bool
	dfs = func(v int) bool {
		used[v] = 1
		isCycle := false
		for _, u := range adj[v] {
			if used[u] == 1 {
				return true
			} else if used[u] == 0 {
				isCycle = isCycle || dfs(u)
			}
		}

		used[v] = 2
		ans[i] = v
		i -= 1
		return isCycle
	}

	for i := 0; i < numCourses; i++ {
		if dfs(i) {
			return make([]int, 0)
		}
	}
	return ans
}
