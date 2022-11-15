
public class Main {
	//Print Array
	static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if (i != arr.length - 1) {System.out.print(", ");}
		}
		System.out.print("]");
		return;
	}

	//Converts String[] to int[]. If any value in the array is not an integer, passes error and returns null.
	static int[] convertStringArrayToIntArray(String[] stringArray) {
		int[] intArray = new int[stringArray.length];
		for (int i = 0; i<stringArray.length; i++) {
			try {
				intArray[i] = Integer.parseInt(stringArray[i]);
			}
			catch(NumberFormatException nfe){
				System.out.println("Error: Non-integer passed as argument.");
				return null;
			}
		}
		return intArray;
	}
	
	public static void main(String[] args) {
		Sort s = new Bubble();
		printArray(s.sort(convertStringArrayToIntArray(args)));		
	}
}