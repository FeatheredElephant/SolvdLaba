package wordcounter;

import org.apache.commons.text.*;

import com.google.common.collect.Multiset;
import com.google.common.collect.HashMultiset;

import app.IOManager;

import java.io.*;

import org.apache.commons.io.FileUtils;

public class WordCounter {
	private Multiset<String> set;
	
	public WordCounter(){
		set = HashMultiset.create();
	}
	
	public void countWords(String qualifiedName){
		
		String input;
		File file = new File(qualifiedName);
		
		try {
			file.createNewFile();
			input = FileUtils.readFileToString(file, (String)null);
			IOManager.getInstance().println("Imported string: " + input);
		} catch (IOException e) {
			IOManager.getInstance().reportError(e);
			return;
		}
		
		if (input.isEmpty()) return;
		input = input.toLowerCase();
		
		StringTokenizer tokenizer = new StringTokenizer(input);
		while (tokenizer.hasNext()) {
			//filter undesired words here
			set.add(tokenizer.next());
		}
		try {
			file = new File("./src/main/wordcount.txt");
			file.createNewFile();
			IOManager.getInstance().println("Output string: " + set.toString());
			FileUtils.writeStringToFile(file, set.toString(), (String)null);
		} catch (IOException e) {
			IOManager.getInstance().reportError(e);
			e.printStackTrace();
			return;
		}
	}
}
