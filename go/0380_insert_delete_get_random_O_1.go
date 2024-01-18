package main

import (
	"math/rand"
)

type RandomizedSet struct {
	listVal []int
	mapVal  map[int]int
}

func Constructor6() RandomizedSet {
	return RandomizedSet{listVal: make([]int, 0),
		mapVal: make(map[int]int)}
}

func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.mapVal[val]; ok {
		return false
	}
	i := len(this.listVal)
	this.mapVal[val] = i
	this.listVal = append(this.listVal, val)
	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	/*
		idx, ok := this.hash[val]
		if !ok {
			return false
		}
		last := this.array[this.length-1]
		this.array[idx] = last
		this.hash[last] = idx
		this.array = this.array[:len(this.array)-1]
		delete(this.hash, val)
		this.length--
		return true
	*/
	if _, ok := this.mapVal[val]; !ok {
		return false
	}
	i := this.mapVal[val]
	n := len(this.listVal)
	this.listVal[i], this.listVal[n-1] = this.listVal[n-1], this.listVal[i]
	this.listVal = this.listVal[:n-1]
	if i < n-1 {
		this.mapVal[this.listVal[i]] = i
	}
	delete(this.mapVal, val)
	return true
}

func (this *RandomizedSet) GetRandom() int {
	i := rand.Intn(len(this.listVal))
	return this.listVal[i]
}
