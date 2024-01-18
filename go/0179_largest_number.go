package main

import (
	"sort"
	"strconv"
	"strings"
)

func largestNumber(nums []int) string {
	s := make([]string, len(nums))
	for i := 0; i < len(nums); i++ {
		s[i] = strconv.Itoa(nums[i])
	}
	sort.Slice(s, func(i, j int) bool {
		s1 := s[i]
		s2 := s[j]
		if s1+s2 > s2+s1 {
			return true
		}
		return false
		/*
			for strings.HasPrefix(s1, s2) || strings.HasPrefix(s2, s1) {
				for strings.HasPrefix(s1, s2) {
					s1 = s1[len(s2):]
				}
				if s1 == "" {
					return false
				}
				for strings.HasPrefix(s2, s1) {
					s2 = s2[len(s1):]
				}
				if s2 == "" {
					return false
				}
			}
			return s1 > s2
		*/
	})
	if s[0] == "0" {
		return s[0]
	}
	return strings.Join(s, ``)
}
