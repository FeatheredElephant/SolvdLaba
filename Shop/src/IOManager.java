import java.util.*;

public class IOManager {
	private Scanner scanner;
	
	static <T> int contextMenu(ArrayList<T> array) {
		int index = 1;
		for(T t:array) {
			System.out.println(index + ". " + t.toString());
		}
		
	}
	
	IOManager(){
		scanner = new Scanner(System.in);
	}
}
