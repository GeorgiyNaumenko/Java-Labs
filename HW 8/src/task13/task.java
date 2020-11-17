package task13;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class task {
	
	public static void main(String[] args) throws IOException{
		
		File data = new File("D:\\Eclipse Workspace\\HW 8\\src\\task13\\dataset");
		FileReader fileReader = new FileReader(data);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String> dataset = new ArrayList<>();
		String[] current = {};
		String car_name_owners = "";
		while(bufferedReader.ready()) {
			dataset.add(bufferedReader.readLine());
		}
		bufferedReader.close();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter car:");
		String car_name = input.nextLine();
		input.close();
		
		for (int i = 0; i < dataset.size(); i++) {
			current = dataset.get(i).split(" ");
			if (current[0].equals(car_name)) {
				System.out.println(current[0]);
				car_name_owners = car_name_owners + current[2] + ", " + current[1] + System.lineSeparator();
			}
		}
		if (car_name_owners.length() == 0) {
			car_name_owners = "There are no " + car_name + " owners!";
		}
		System.out.println("Owners of " + car_name+ ":");
		System.out.println(car_name_owners);
		
		Map <String, ArrayList<String>> dict = new HashMap <String, ArrayList<String>>();
		for (int i = 0; i < dataset.size(); i++) {
			current = dataset.get(i).split(" ");
			if (!dict.containsKey(current[0])) {
				dict.put(current[0], new ArrayList<String>());
			}
			dict.get(current[0]).add(current[2] + " (" + current[1] + ")");
		}
		
		Map <String, Integer> dict1 = new HashMap <String, Integer>();
		for (int i = 0; i < dataset.size(); i++) {
			current = dataset.get(i).split(" ");
			if (!dict1.containsKey(current[0])) {
				dict1.put(current[0], 0);
			}
			dict1.put(current[0], dict1.get(current[0]) + 1);
		}
		
		System.out.println(dict);
		System.out.println(dict1);
	}
}
