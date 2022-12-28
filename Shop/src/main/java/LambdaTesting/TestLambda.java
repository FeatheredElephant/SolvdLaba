package LambdaTesting;

import java.util.ArrayList;

import app.IOManager;

public class TestLambda {
	ArrayList<String> testList = new ArrayList<>();
	IGeneric iDisplay;
	
	public TestLambda(){
		addItemsToArray();
		iDisplay = () -> {
			IOManager.getInstance().println(testList);
		};
	}
	
	public void display() {
		iDisplay.display();
	}
	
	void addItemsToArray() {
		testList.add("First");
		testList.add("Second");
		testList.add("Third");
		testList.add("Fourth");
		testList.add("Fifth");
		testList.add("Sixth");
	}
	
	
}
