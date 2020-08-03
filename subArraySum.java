import java.io.BufferedInputStream;
import java.util.Scanner;

/* subArraySum.java
 *
 * this program takes an array and an integer and finds a subarray
 * that adds up to that integer, if one exists, else it returns -1
 *
 */
public class subArraySum {

	/* main
	 *
	 * this is where the program takes in the user input such as the
	 * array and target sum. It will prompt the user for each input as
	 * needed
	 *
	 * params: String[]
	 */
	public static void main(String[] args){
		// initialize necessary variables
		int aSize;
		int s;
		int[] ans;
		Scanner scanner = new Scanner(System.in);
		
		// prompts user for number of arrays
		System.out.println("How many arrays?");
		int numProblems = scanner.nextInt();

		// goes through the necessary prompts and calculations for each separate set of array and sum
		for (int i = 0; i < numProblems; i++) {
			// prompts user for size of array and target sum for current problem
			System.out.println("How many ints in array " + (i+1) + " and what is the sum you would like?");
			aSize = scanner.nextInt();
			s = scanner.nextInt();

			// prompts user for elements of array
			System.out.println("Input array " + (i+1) + " here: ");

			// creates array based on user input
			int[] a = new int[aSize];
			for (int j = 0; j < aSize; j++) {
				a[j]=scanner.nextInt();
			}

			// uses helper function to find resultant subarray
			ans = sumFinder(a,s);

			// if unable to find subarray that adds to target sum then return -1 else return answer
			// and omit any values not part of solution subarray
			if (ans[0] == -1){
				System.out.println(-1);
				System.out.println("Cannot make subarray with specified sum");
			} else {
				for (int j = 0; j < ans.length; j++) {
					if (ans[j] != -1) {
						System.out.print(ans[j] + " ");
					}
				}
			}

		}
	}

	/* sumFinder function
	 *
	 * helper function for main that takes in each array and target sum
	 * and returns the sub array that adds to that sum should it exist.
	 * 
	 * params: int[], int
	 */
	public static int[] sumFinder(int[] arr, int targetSum) {
		// initialize variables
		int len = arr.length;
		int currentSum = 0;;
		int[] currentSubArr = new int[len];
		int subIdx = 0;

		// loop through array starting at each element to check if any set of
		// consecutive elements add to the target sum
		for (int i = 0; i < len; i++){
			for (int j = i; j < len; j++){
				currentSum += arr[j];
				if ( currentSum == targetSum ) {
					currentSubArr[subIdx] = arr[j];
					return currentSubArr;
				} else if (currentSum < targetSum) {
					currentSubArr[subIdx] = arr[j];
					subIdx++;
				}
			}
			// if unsuccessful from current element, reset variables
			subIdx = 0;
			for (int j = 0; j < currentSubArr.length; j++){
				currentSubArr[j] = -1;
			}
			currentSum = 0;
		}
		
		return null;
	}

}