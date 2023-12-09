package main

/*
func longestCommonPrefix(strs []string) string {
    var res strings.Builder
    for i := 0; i < len(strs[0]); i++ {
        for _, s := range(strs) {
            if i == len(s) || s[i] != strs[0][i] {
                return res.String()
            }
        }
        res.WriteByte(strs[0][i])
    }
    return res.String()
}

*/
func longestCommonPrefix(strs []string) string {
	res := make([]byte, 0)
	for i := 0; i < len(strs[0]); i++ {
		for j := 1; j < len(strs); j++ {
			if i == len(strs[j]) || strs[0][i] != strs[j][i] {
				return string(res)
			}
		}
		res = append(res, strs[0][i])
	}
	return string(res)
}
