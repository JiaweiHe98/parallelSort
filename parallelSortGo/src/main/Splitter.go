package main

func split(length int, parts int) [][]int {
	numPerPart := length / parts
	remaining := length % parts
	output := make([][]int, parts)
	for i := range output {
		output[i] = make([]int, 2)
	}

	start := 0

	for i := 0; i < parts-1; i++ {
		output[i][0] = start

		if remaining > 0 {
			output[i][1] = start + numPerPart + 1
			remaining--

		} else {
			output[i][1] = start + numPerPart
		}

		start = output[i][1]
	}

	output[parts-1][0] = start
	output[parts-1][1] = length

	return output
}
