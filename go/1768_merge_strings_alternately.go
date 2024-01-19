package main

func mergeAlternately(word1 string, word2 string) string {
	i, j := 0, 0
	res := make([]byte, 0, len(word1)+len(word2))
	for i < len(word1) && j < len(word2) {
		res = append(res, word1[i])
		res = append(res, word2[j])
		i += 1
		j += 1
	}
	for i < len(word1) {
		res = append(res, word1[i])
		i += 1
	}
	for j < len(word2) {
		res = append(res, word2[j])
		j += 1
	}
	return string(res)
}
