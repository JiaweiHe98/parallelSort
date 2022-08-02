package main

import (
	"math/rand"
	"time"
)

func ArrayGen(length int, low int, high int) []int {
	output := make([]int, length)
	source := rand.NewSource(time.Now().UnixNano())
	sRand := rand.New(source)

	for i := 0; i < length; i++ {
		output[i] = sRand.Intn(high-low) + low
	}

	return output
}
