package main

type DoubleNode struct {
	key   int
	value int
	prev  *DoubleNode
	next  *DoubleNode
}

type LRUCache struct {
	left  *DoubleNode //LRU
	right *DoubleNode //MRU
	m     map[int]*DoubleNode
	size  int
	cap   int
}

func Constructor11(capacity int) LRUCache {
	left := &DoubleNode{}
	right := &DoubleNode{}
	left.next = right
	right.prev = left
	return LRUCache{
		left:  left,
		right: right,
		m:     make(map[int]*DoubleNode),
		size:  0,
		cap:   capacity,
	}
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.m[key]; ok {
		prev := node.prev
		next := node.next
		prev.next = next
		next.prev = prev

		prev = this.right.prev
		prev.next = node
		node.prev = prev
		node.next = this.right
		this.right.prev = node

		return node.value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	var node *DoubleNode
	var exist bool
	if node, exist = this.m[key]; exist {
		prev := node.prev
		next := node.next
		prev.next = next
		next.prev = prev
		node.value = value
	}

	if !exist && this.cap == this.size {
		lru := this.left.next
		next := lru.next
		this.left.next = next
		next.prev = this.left
		delete(this.m, lru.key)

		this.size -= 1
	}

	if !exist {
		node = &DoubleNode{key: key, value: value}
		this.m[key] = node
		this.size += 1
	}

	prev := this.right.prev
	prev.next = node
	node.prev = prev
	node.next = this.right
	this.right.prev = node
}
