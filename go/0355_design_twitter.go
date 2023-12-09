package main

import "container/heap"

type TupleMaxHeap [][4]int

func (h TupleMaxHeap) Len() int { return len(h) }
func (h TupleMaxHeap) Less(i, j int) bool {
	return h[i][0] > h[j][0]
}
func (h TupleMaxHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h *TupleMaxHeap) Push(x any) {
	*h = append(*h, x.([4]int))
}

func (h *TupleMaxHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

type Twitter struct {
	followers map[int]map[int]struct{}
	posts     map[int][][2]int
	time      int
}

func Constructor1() Twitter {
	t := Twitter{}
	t.followers = make(map[int]map[int]struct{}, 0)
	t.posts = make(map[int][][2]int)
	t.time = 0
	return t
}

func (this *Twitter) PostTweet(userId int, tweetId int) {
	initFollowers(userId, this)
	if _, ok := this.posts[userId]; !ok {
		this.posts[userId] = make([][2]int, 0)
	}
	this.posts[userId] = append(this.posts[userId], [...]int{tweetId, this.time})
	this.time += 1
}

func (this *Twitter) GetNewsFeed(userId int) []int {
	h := &TupleMaxHeap{}
	heap.Init(h)
	followees := this.followers[userId]
	for followeeId, _ := range followees {
		i := len(this.posts[followeeId]) - 1
		if i >= 0 {
			heap.Push(h, [...]int{this.posts[followeeId][i][1], this.posts[followeeId][i][0], followeeId, i - 1})
		}
	}

	newsFeed := make([]int, 0)
	for len(newsFeed) < 10 && len(*h) > 0 {
		e := heap.Pop(h).([4]int)
		twetId := e[1]
		newsFeed = append(newsFeed, twetId)
		followeeId := e[2]
		i := e[3]
		if i >= 0 {
			p := this.posts[followeeId][i]
			heap.Push(h, [...]int{p[1], p[0], followeeId, i - 1})
		}

	}
	return newsFeed
}

func initFollowers(userId int, this *Twitter) {
	if _, ok := this.followers[userId]; !ok {
		m := make(map[int]struct{})
		m[userId] = struct{}{}
		this.followers[userId] = m
	}
}

func (this *Twitter) Follow(followerId int, followeeId int) {
	initFollowers(followerId, this)
	this.followers[followerId][followeeId] = struct{}{}
}

func (this *Twitter) Unfollow(followerId int, followeeId int) {
	if _, ok := this.followers[followerId]; ok {
		delete(this.followers[followerId], followeeId)
	}
}
