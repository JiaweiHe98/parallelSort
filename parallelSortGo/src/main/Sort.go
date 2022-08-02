package main

import "fmt"

func SortWrapper(arr []int, start int, end int) {
	defer func() {
		wg.Done()
		fmt.Println("finished", start, end)
	}()
	Sort(arr, start, end)
}

func Sort(arr []int, start int, end int) {

	if start >= end {
		return
	}

	pt := start - 1
	for i := start; i < end; i++ {
		if arr[i] < arr[end] {
			pt++
			arr[pt], arr[i] = arr[i], arr[pt]
		}
	}
	pt++
	arr[pt], arr[end] = arr[end], arr[pt]

	Sort(arr, start, pt-1)
	Sort(arr, pt+1, end)
}
