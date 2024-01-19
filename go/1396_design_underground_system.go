package main

import "strconv"

type Tuple struct {
	s1 string
	s2 string
}

type UndergroundSystem struct {
	checkedIn map[int]Tuple
	tripsTime map[Tuple]int64
	tripsCnt  map[Tuple]int
}

func Constructor8() UndergroundSystem {
	return UndergroundSystem{
		checkedIn: make(map[int]Tuple),
		tripsTime: make(map[Tuple]int64),
		tripsCnt:  make(map[Tuple]int),
	}
}

func (this *UndergroundSystem) CheckIn(id int, stationName string, t int) {
	this.checkedIn[id] = Tuple{s1: stationName, s2: strconv.Itoa(t)}
}

func (this *UndergroundSystem) CheckOut(id int, stationName string, t int) {
	startStation := this.checkedIn[id].s1
	startTime, _ := strconv.Atoi(this.checkedIn[id].s2)
	key := Tuple{s1: startStation, s2: stationName}
	this.tripsTime[key] += int64(t - startTime)
	this.tripsCnt[key] += 1
}

func (this *UndergroundSystem) GetAverageTime(startStation string, endStation string) float64 {
	key := Tuple{s1: startStation, s2: endStation}
	return float64(this.tripsTime[key]) / float64(this.tripsCnt[key])
}
