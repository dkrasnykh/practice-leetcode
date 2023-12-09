package main

func findDifferentBinaryString(nums []string) string {
	m := make(map[string]struct{})
	for i := 0; i < len(nums); i++ {
		m[nums[i]] = struct{}{}
	}
	n := len(nums[0])
	curr := make([]byte, 0)
	bin := []byte{'0', '1'}

	var backtrack func(ind int) string
	backtrack = func(ind int) string {
		if len(curr) == n {
			if _, ok := m[string(curr)]; !ok {
				return string(curr)
			} else {
				return ""
			}
		}
		var ans string
		for _, v := range bin {
			curr = append(curr, v)
			ans = backtrack(ind + 1)
			if len(ans) == n {
				return ans
			}
			curr = curr[:len(curr)-1]
		}
		return ""
	}
	return backtrack(0)
}
