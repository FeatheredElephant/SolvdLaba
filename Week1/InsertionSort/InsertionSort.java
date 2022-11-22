public class InsertionSort {

	// Converts String[] to int[]. If any value in the array is not an integer,
	// passes error and returns null.
	static int[] convertStringArrayToIntArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			try {
				intArray[i] = Integer.parseInt(stringArray[i]);
			} catch (NumberFormatException nfe) {
				System.out.println("Error: Non-integer passed as argument.");
				return null;
			}
		}
		return intArray;
	}

	// Implements InsertionSort
	static int[] sort(int[] intArray) {
		for (int i = 1; i < intArray.length; i++) {
			int key = intArray[i];
			int j = i - 1;

			while (j >= 0 && intArray[j] > key) {
				intArray[j + 1] = intArray[j];
				j = j - 1;
			}
			intArray[j + 1] = key;
		}
		return intArray;
	}

	// Print Array
	static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
		return;
	}

	public final static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No arguments provided.");
			return;
		}
		printArray(sort(convertStringArrayToIntArray(args)));
	}
}