package main

import "strings"

func numUniqueEmails(emails []string) int {
	m := make(map[string]struct{})
	for i := 0; i < len(emails); i++ {
		j := strings.Index(emails[i], `@`)
		name := emails[i][:j]
		domain := emails[i][j:]
		j = strings.Index(name, `+`)
		if j != -1 {
			name = name[:j]
		}
		name = strings.ReplaceAll(name, `.`, ``)
		e := strings.Join([]string{name, domain}, "")
		m[e] = struct{}{}
	}
	return len(m)
}
