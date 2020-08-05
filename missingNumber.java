import java.util.Scanner;

/* filename: missingNumber.java
 *
 * This takes an array of size n-1 with numbers 1 to n with one element
 * missing and returns the missing element
 *
 */

public class missingNumber {

	/* main
	 *
	 * this is where the program takes in the user input such as the array,
	 * array size, and number of cases. It will prompt the user for each
	 * input as needed. It will return the mssing number at the end.
	 *
	 * params: String[]
	 */
	public static void main(String[] args) {
		// initialize variables
		int numCases;
		int len;
		int missingNo;
		Scanner scan = new Scanner(System.in);

		// prompt user for number of test cases
		System.out.println("\nHow many testcases");
		numCases = scan.nextInt();

		// loop once per test case
		for (int i = 0; i < numCases; i++) {

			// prompt user for length of current array if no elements were 
			// missing and then initializes int array
			System.out.println("\nWhat is the length of array " + (i+1));
			len = scan.nextInt();
			len--;
			int[] array = new int[len];

			// prompts user for elements of the array
			System.out.println("\nWhat are the elements of the array: ");
			for (int j = 0; j < len; j++) {
				array[j] = scan.nextInt();
			}

			// uses missingNo function to calculate missing number
			missingNo = missingNo(array);

			System.out.println("\nThe missing number is " + missingNo);
		}

	}

	/* function: missingNo
	 *
	 * this takes an input array and calculates the missing element 
	 * assuming there is only one element missing
	 *
	 * @params: int[]
	 */
	public static int missingNo(int[] arr) {
		//initialize variables
		int len = arr.length;
		int arrSum = 0;
		int actualSum = ((len + 2)*(len + 1))/2;

		//calculate sum of elements in array
		for (int i = 0; i < len; i++) {
				arrSum += arr[i];
		}

		// the difference will equal the missing number
		return actualSum - arrSum;
	}

}