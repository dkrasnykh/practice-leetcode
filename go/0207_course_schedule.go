package main

func canFinish(numCourses int, prerequisites [][]int) bool {
	preMap := make(map[int][]int)
	for i := 0; i < numCourses; i++ {
		preMap[i] = make([]int, 0)
	}
	for i := 0; i < len(prerequisites); i++ {
		crs := prerequisites[i][0]
		pre := prerequisites[i][1]
		preMap[crs] = append(preMap[crs], pre)
	}
	visitSet := make(map[int]struct{})
	var dfs func(course int) bool
	dfs = func(crs int) bool {
		if _, ok := visitSet[crs]; ok {
			return false
		}
		if len(preMap[crs]) == 0 {
			return true
		}
		visitSet[crs] = struct{}{}
		for pre := range preMap[crs] {
			if !dfs(pre) {
				return false
			}
		}
		delete(visitSet, crs)
		preMap[crs] = preMap[crs][0:0]
		return true
	}
	for crs := 0; crs < numCourses; crs++ {
		if !dfs(crs) {
			return false
		}
	}
	return true
}
