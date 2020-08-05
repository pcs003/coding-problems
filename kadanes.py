# filename: kadanes.py
# 
# Takes an array of specified size and find contiguous sub array with maximum sum


# Prompts user for number of arrays to be analyzed
numProblems = int(input ("How many arrays: "))

# loops once for each array
for i in range(numProblems):
	# prompts user for size of current array then initializes array
	print("What is the length of array " + str(i+1))
	length = int(input()) #length of current array
	array = [0]*length # current array

	# prompts user for elements of array
	print("What are the elements of the array (input with a space between each element): ")
	arrayStr = input() # string input form of array

	# splits user input into each element and stores in array
	splitArr = arrayStr.split(" ")
	idx = int(0) 
	for x in splitArr:
		array[idx] = x
		idx = idx + 1

	# handles incorrect user input
	if (len(splitArr) < length): # too few elements
		print("Not enough elements, try again")
		break
	if (len(splitArr) > length): # too many elements
		print("Too many elements, try again")
		break

	# intialize variables for finding max sum
	currentSum = int(0);
	maxSum = int(array[0]);

	# nested for loops that checks max sum starting at each element
	for j in range(length):
		currentSum = int(array[j])
		for k in range(j + 1, length):
			currentSum = int(currentSum) + int(array[k])
			if (currentSum > maxSum):
				maxSum = int(currentSum)


	print("The maximum sum of a contiguous subarray is " + str(maxSum) + "\n")		