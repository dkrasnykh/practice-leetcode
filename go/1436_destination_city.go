package main

func destCity(paths [][]string) string {
	m := make(map[string]bool)
	for i := 0; i < len(paths); i++ {
		m[paths[i][0]] = true
	}
	for i := 0; i < len(paths); i++ {
		if !m[paths[i][1]] {
			return paths[i][1]
		}
	}
	return ""
}
