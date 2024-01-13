package main

import "strconv"

type Codec struct {
	EncodeMap map[string]string
	DecodeMap map[string]string
}

const base = `http://tinyurl.com/`

func Constructor5() Codec {
	return Codec{
		EncodeMap: make(map[string]string),
		DecodeMap: make(map[string]string),
	}
}

func (this *Codec) encode(longUrl string) string {
	if _, ok := this.EncodeMap[longUrl]; !ok {
		shortUrl := base + strconv.Itoa(len(this.EncodeMap)+1)
		this.EncodeMap[longUrl] = shortUrl
		this.DecodeMap[shortUrl] = longUrl
	}
	return this.EncodeMap[longUrl]
}

func (this *Codec) decode(shortUrl string) string {
	return this.DecodeMap[shortUrl]
}
