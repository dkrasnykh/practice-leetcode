package main

func checkInclusion1(s1 string, s2 string) bool {
	if len(s1) > len(s2) {
		return false
	}
	s1Count, s2Count := [26]int{}, [26]int{}
	for i := 0; i < len(s1); i++ {
		s1Count[s1[i]-'a'] += 1
		s2Count[s2[i]-'a'] += 1
	}
	matches := 0
	for i := 0; i < 26; i++ {
		if s1Count[i] == s2Count[i] {
			matches += 1
		}
	}
	l := 0
	for r := len(s1); r < len(s2); r++ {
		if matches == 26 {
			return true
		}
		index := s2[r] - 'a'
		s2Count[index] += 1
		if s1Count[index] == s2Count[index] {
			matches += 1
		} else if s1Count[index]+1 == s2Count[index] {
			matches -= 1
		}
		index = s2[l] - 'a'
		s2Count[index] -= 1
		if s1Count[index] == s2Count[index] {
			matches += 1
		} else if s1Count[index]-1 == s2Count[index] {
			matches -= 1
		}
		l += 1
	}
	return (matches == 26)
}
