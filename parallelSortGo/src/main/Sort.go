package main

import "sync"

func SortWrapper(arr []int, start int, end int, wg *sync.WaitGroup) {
	defer wg.Done()
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
