package task_16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class task {

	public static void main(String[] args) throws IOException {
		
		File data = new File("D:\\Eclipse Workspace\\HW 10\\src\\task_16\\eng_text");
		FileReader fileReader = new FileReader(data);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<myString> dataset = new ArrayList<>();
		String[] current = {};
		while(bufferedReader.ready()) {
			current = bufferedReader.readLine().split(" ");
			for (int i = 0; i < current.length; i++) {
				dataset.add(new myString(current[i]));
			}
		}
		bufferedReader.close();
		
		
		// Треба гарно підібрати хеш-функцію, бо якщо слово занадто довге, значення базової функції
		// перевищує допустимі значення типу int та вважає деякі слова однаковими після override
		HashSet<myString> h = new HashSet<myString>(dataset);
		System.out.println(h);
		

	}
}
