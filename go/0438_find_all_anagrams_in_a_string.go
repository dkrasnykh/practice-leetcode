package main

// каждый раз проверять равны ли две мапы?
func findAnagrams(s string, p string) []int {
	ms := map[byte]int{}
	mp := map[byte]int{}
	res := make([]int, 0)
	if len(p) > len(s) {
		return res
	}
	for i := 0; i < len(p); i++ {
		mp[p[i]] += 1
	}
	equals := func(m1 map[byte]int, m2 map[byte]int) bool {
		if len(m1) != len(m2) {
			return false
		}
		for k, _ := range m1 {
			if m1[k] != m2[k] {
				return false
			}
		}
		return true
	}
	for i := 0; i < len(s); i++ {
		ms[s[i]] += 1

		if i >= len(p)-1 {
			l := i - len(p) + 1
			if equals(ms, mp) {
				res = append(res, l)
			}
			ms[s[l]] -= 1
			if ms[s[l]] == 0 {
				delete(ms, s[l])
			}
		}
	}
	return res
}

/*
func main() {
	fmt.Println(findAnagrams(`cbaebabacd`, `abc`))
}
*/
