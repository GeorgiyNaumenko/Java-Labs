package task_3;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class task {

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> nums = new ArrayList<>();
		int n = input.nextInt();
		for (int i = 0; i < n; i++) {
			nums.add(input.nextInt());
		}
		input.close();
		
		FileOutputStream fileOutputStream = new FileOutputStream("F");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		for (int i = 0; i < n; i++) {
			objectOutputStream.writeInt(nums.get(i));
		}
		objectOutputStream.close();
		
		ArrayList<Integer> read_nums = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream("F");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		for (int i = 0; i < n; i++) {
			read_nums.add(objectInputStream.readInt());
		}
		objectInputStream.close();
		
		ArrayList<Integer> n1 = even_nums(read_nums);
		ArrayList<Integer> n2 = nums_div_3_5(read_nums);
		ArrayList<Integer> n3 = sq_nums(read_nums);
		ArrayList<Integer> n4 = set_nums(read_nums);
		
		FileOutputStream fileOutputStream1 = new FileOutputStream("G");
		ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
		for (int i = 0; i < n1.size(); i++) {
			objectOutputStream.writeInt(n1.get(i));
		}
		for (int i = 0; i < n2.size(); i++) {
			objectOutputStream.writeInt(n2.get(i));
		}
		for (int i = 0; i < n3.size(); i++) {
			objectOutputStream.writeInt(n3.get(i));
		}
		for (int i = 0; i < n4.size(); i++) {
			objectOutputStream.writeInt(n4.get(i));
		}
		objectOutputStream1.close();
	}
	
	public static ArrayList<Integer> even_nums(ArrayList<Integer> nums){
		
		ArrayList<Integer> new_nums = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) % 2 == 0) {
				new_nums.add(nums.get(i));
			}
		}
		return new_nums;
	}
	
	public static ArrayList<Integer> nums_div_3_5(ArrayList<Integer> nums){
		
		ArrayList<Integer> new_nums = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) % 3 == 0 | nums.get(i) % 5 == 0) {
				new_nums.add(nums.get(i));
			}
		}
		return new_nums;
	}
	
	public static ArrayList<Integer> sq_nums(ArrayList<Integer> nums){
		
		ArrayList<Integer> new_nums = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			if (Math.sqrt((double) nums.get(i)) == (int) Math.sqrt((double) nums.get(i))) {
				new_nums.add(nums.get(i));
			}
		}
		return new_nums;
	}
	
	public static ArrayList<Integer> set_nums(ArrayList<Integer> nums){
		
		ArrayList<Integer> new_nums = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			if (!new_nums.contains(nums.get(i))) {
				new_nums.add(nums.get(i));
			}
		}
		return new_nums;
	}
}
