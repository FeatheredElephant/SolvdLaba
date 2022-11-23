package Shop;
import java.util.ArrayList;

public class Main {
	public static final void main(String[] args) {
		IOManager io = new IOManager();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i<10; i++) {
			nums.add(i);
		}
		
		System.out.print(io.selectFromArray("Please select your favorite number", nums));
	}
}