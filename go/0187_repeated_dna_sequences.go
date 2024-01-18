package main

func findRepeatedDnaSequences(s string) []string {
	seen, res := map[string]bool{}, map[string]struct{}{}
	for l := 0; l < len(s)-9; l++ {
		w := s[l : l+10]
		if seen[w] {
			res[w] = struct{}{}
		}
		seen[w] = true
	}
	res_list := []string{}
	for k, _ := range res {
		res_list = append(res_list, k)
	}
	return res_list
}
