package main

type MinStack struct {
	value   []int
	minElem []int
}

func Constructor9() MinStack {
	return MinStack{
		value:   make([]int, 0),
		minElem: make([]int, 0),
	}
}

func (this *MinStack) Push(val int) {
	this.value = append(this.value, val)
	if len(this.minElem) == 0 {
		this.minElem = append(this.minElem, val)
		return
	}
	lastMin := this.minElem[len(this.minElem)-1]
	this.minElem = append(this.minElem, min(lastMin, val))
}

func (this *MinStack) Pop() {
	size := len(this.value)
	this.value = this.value[:size-1]
	this.minElem = this.minElem[:size-1]
}

func (this *MinStack) Top() int {
	size := len(this.value)
	return this.value[size-1]
}

func (this *MinStack) GetMin() int {
	size := len(this.minElem)
	return this.minElem[size-1]
}
