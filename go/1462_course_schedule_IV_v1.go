package main

//https://www.youtube.com/watch?v=cEW05ofxhn0
func checkIfPrerequisite1(numCourses int, prerequisites [][]int, queries [][]int) []bool {
	adj := make([][]int, numCourses)
	for _, v := range prerequisites {
		prereq := v[0]
		crs := v[1]
		adj[crs] = append(adj[crs], prereq)
	}

	prereqMap := make(map[int]map[int]bool)

	var dfs func(crs int) map[int]bool
	dfs = func(crs int) map[int]bool {
		if _, ok := prereqMap[crs]; !ok {
			prereqMap[crs] = make(map[int]bool)
			for _, prereq := range adj[crs] {
				tmp := dfs(prereq)
				for k := range tmp {
					prereqMap[crs][k] = true
				}
			}
			prereqMap[crs][crs] = true
		}
		return prereqMap[crs]
	}

	for crs := 0; crs < numCourses; crs++ {
		dfs(crs)
	}
	res := make([]bool, 0, len(queries))
	for _, val := range queries {
		u := val[0]
		v := val[1]
		_, ok := prereqMap[v][u]
		res = append(res, ok)
	}
	return res
}
