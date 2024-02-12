package main

func checkInclusion(s1 string, s2 string) bool {
	size := len(s1)
	if size > len(s2) {
		return false
	}
	m1, m2 := map[byte]int{}, map[byte]int{}
	for i := 0; i < size; i++ {
		m1[s1[i]] += 1
	}
	equals := func() bool {
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
	for i := 0; i < len(s2); i++ {
		m2[s2[i]] += 1
		if i >= size {
			l := i - size
			m2[s2[l]] -= 1
			if m2[s2[l]] == 0 {
				delete(m2, s2[l])
			}
		}
		if i >= size-1 {
			if equals() {
				return true
			}
		}
	}
	return false
}
