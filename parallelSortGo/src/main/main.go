package main

import (
	"fmt"
	"sync"
)

var wg sync.WaitGroup

func main() {
	length := 100
	low := -100
	high := 100
	partNum := 5

	arr := ArrayGen(length, low, high)
	parts := split(length, partNum)

	wg.Add(partNum)
	for i := 0; i < partNum; i++ {
		startEnd := parts[i]
		go SortWrapper(arr, startEnd[0], startEnd[1]-1)
	}

	wg.Wait()

	for i := 1; i < partNum; i++ {
		Merge(arr, 0, parts[i][0]-1, parts[i][0], parts[i][1]-1)
	}

	for i := 0; i < len(arr)-1; i++ {
		if arr[i+1] < arr[i] {
			panic(any("error"))
		}
	}

	fmt.Println(arr)
}
