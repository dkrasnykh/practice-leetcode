package main

import "strconv"

func calPoints(operations []string) int {
	stack := make([]int, 0, len(operations))

	for _, op := range operations {
		switch op {
		case "+":
			v := stack[len(stack)-1] + stack[len(stack)-2]
			stack = append(stack, v)
		case "D":
			v := 2 * stack[len(stack)-1]
			stack = append(stack, v)
		case "C":
			stack = stack[:len(stack)-1]
		default:
			v, _ := strconv.Atoi(op)
			stack = append(stack, v)
		}
	}

	res := 0
	for i := 0; i < len(stack); i++ {
		res += stack[i]
	}
	return res
}
