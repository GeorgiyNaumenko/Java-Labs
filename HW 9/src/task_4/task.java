package task_4;

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
		ArrayList<Integer> write_coefs = new ArrayList<>();
		ArrayList<Integer> write_degs = new ArrayList<>();
		int n = input.nextInt();
		for (int i = 0; i < n+1; i++) {
			write_degs.add(input.nextInt());
			write_coefs.add(input.nextInt());
		}
		input.close();
		
		FileOutputStream fileOutputStream = new FileOutputStream("PolyData");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeInt(n);
		for (int i = 0; i < n+1; i++) {
			objectOutputStream.writeInt(write_coefs.get(i));
			objectOutputStream.writeInt(write_degs.get(i));
		}
		objectOutputStream.close();
		
		ArrayList<Integer> read_coefs = new ArrayList<>();
		ArrayList<Integer> read_degs = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream("PolyData");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		int deg = objectInputStream.readInt();
		for (int i = 0; i < deg+1; i++) {
			read_coefs.add(objectInputStream.readInt());
			read_degs.add(objectInputStream.readInt());
		}
		objectInputStream.close();
		
		Polynom poly = new Polynom(read_coefs, read_degs);
		System.out.println(poly);
		poly.sort_by_deg();
		System.out.println(poly);
	}
}
