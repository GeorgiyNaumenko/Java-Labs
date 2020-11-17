package task17;

import java.util.Scanner;

public class task {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter A:");
		String as = input.nextLine();
		System.out.println("Enter S:");
		String s = input.nextLine();
		System.out.println("Enter C:");
		char c = input.nextLine().charAt(0);
		input.close();
		StringBuilder a = new StringBuilder(as);
		int current = 0;
		int l = a.length();
		
		while (true) {
			current = a.indexOf(s, current);
			if (current >= l-1 || current ==-1) {
				break;
			}
			a.setCharAt(current+1, c);
			current += 1;
		}
		
		System.out.println(a);
	}
}
