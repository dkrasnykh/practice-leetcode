package main

func groupAnagrams(strs []string) [][]string {
	result := make([][]string, 0)
	m := make(map[[26]int][]string)

	getKey := func(s string) [26]int {
		r := [26]int{}
		for i := 0; i < len(s); i++ {
			r[s[i]-'a'] += 1
		}
		return r
	}
	for _, w := range strs {
		key := getKey(w)
		if _, ok := m[key]; !ok {
			m[key] = make([]string, 0)
		}
		m[key] = append(m[key], w)
	}
	for _, v := range m {
		result = append(result, v)
	}
	return result
}
