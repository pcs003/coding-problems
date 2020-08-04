/* filename: countTriplets.cpp
 *
 * This program takes an array from user and outputs the number of triplets in
 * the array. A triplet is a combination of three elements where two pf the 
 * elements add to the third.
 *
 */

#include <iostream>

using namespace std;


/* function: swap
 *
 * this function swaps two integers using their pointers
 *
 * @params: int*, int*
 */
void swap(int* x, int* y){
	int z = *x;
	*x= *y;
	*y = z;
}


/* function: partition
 * 
 * this function takes an array and last element as pivot and then correctly
 * places the pivot element in the sorted array and places all smaller elements
 * below it and all larger elements above it.
 *
 * @params: int[], int, int
 */
int partition (int arr[], int low, int high) {
	//initialize variables
	int idx = low - 1;
	int pivot = arr[high];
	
	//arranges elements based on pivot value
	for (int i = low; i <= high; i++) {
		if (arr[i] < pivot) {
			idx++;
			swap(&arr[idx], &arr[i]);
		}
	}

	swap(&arr[idx + 1], &arr[high]);
	return idx + 1;
}


/* function: quickSort
 *
 * this functionuses the partition function to fund the pivot point of 
 * and inputted array and then recursively calls itself on the array below
 * the pivot andabove the pivot. In each recursion it finds a new pivot.
 *
 * @params: int[], int, int
 */
void quickSort(int arr[], int low, int high) {
	if (low < high) {
		int pIdx = partition(arr, low, high);
		quickSort(arr, low, pIdx - 1);
		quickSort(arr, pIdx+1, high);;
	}
}

/* function: main
 *
 * this is where the program prompts the user for the number of arrays to be
 * solved, the size of each of those arrays, and the contents of each array. 
 * It then uses the quicksort function to sort the inputted array and then
 * calculates the number of tripletsby iterating through the array using two
 * pointers to check sums.
 *
 * @params: none
 */
int main() {
	// initialize variables
	int numArrays;
	int len;
	int a,b,c;

	// prompt user for number of problems
	cout << "How many arrays?" << endl;
	cin >> numArrays;

	// loops based on number of problems
	for (int i = 0; i < numArrays; i++) {
		// prompt user for array size and then initialize array
		cout << "How many elements in array " << (i+1) << endl;
		cin >> len;
		int array [len] = {};

		// prompt user for contents of array and then fill array
		cout << "Now input the elements of the array separated by spaces: " << endl;
		for (int j = 0; j < len; j++) {
			cin >> array[j];
		}

		// sort array using quick sort algorithm
		quickSort(array, 0, len - 1);

		// initialize variables for finding triplets
		int low = 0;
		int high = len - 2;
		int sumIdx = len - 1;
		int tripCount = 0;

		// iterate through array using two pointers to check sums for triplets
		for (int j = 0; j < len; j++) {
			if (array[low] + array[high] == array[sumIdx]) {
				tripCount++; // found a triplet
				low++;
				high--;
			} else if (array[low] + array[high] < array[sumIdx]){
				low++;
			} else {
				high--;
			}
		}
		
		cout << "There are " << tripCount << " triplets" << endl;

	}
}