package main

func Merge(arr []int, l1 int, r1 int, l2 int, r2 int) {
	leftCount := r1 - l1 + 1
	rightCount := r2 - l2 + 1
	data := make([]int, leftCount+rightCount)
	pt := 0

	pt1 := l1
	pt2 := l2

	for pt1 <= r1 && pt2 <= r2 {
		if arr[pt1] < arr[pt2] {
			data[pt] = arr[pt1]
			pt1++
		} else {
			data[pt] = arr[pt2]
			pt2++
		}
		pt++
	}

	for pt1 <= r1 {
		data[pt] = arr[pt1]
		pt1++
		pt++
	}

	for pt2 <= r2 {
		data[pt] = arr[pt2]
		pt2++
		pt++
	}

	for i := 0; i < len(data); i++ {
		arr[i+l1] = data[i]
	}

}
