package main

type MyStack struct {
	q []int
}

func Constructor12() MyStack {
	return MyStack{
		q: make([]int, 0),
	}
}

func (this *MyStack) Push(x int) {
	this.q = append(this.q, x)
}

func (this *MyStack) Pop() int {
	size := len(this.q)
	for size > 1 {
		v := this.q[0]
		this.q = this.q[1:]
		this.q = append(this.q, v)
		size -= 1
	}
	v := this.q[0]
	this.q = this.q[1:]
	return v
}

func (this *MyStack) Top() int {
	return this.q[len(this.q)-1]
}

func (this *MyStack) Empty() bool {
	return len(this.q) == 0
}
