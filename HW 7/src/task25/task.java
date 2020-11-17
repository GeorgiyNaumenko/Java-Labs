package task25;

import java.util.Scanner;

public class task {
	
	public static int unicode_distance(char c1, char c2) {
		int code1 = (int) c1, code2 = (int) c2;
		return Math.abs(code2 - code1);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();
		int l = s.length();
		char c = 'c';
		String current = "", currentmax = "";
		int i = 0;
		
		while (i < l) {
			c = s.charAt(i);
			if (current.length() == 0) {
				current += Character.toString(c);
			}
			else if (unicode_distance(c, current.charAt(current.length()-1)) <= 1){
				current += Character.toString(c);
			}
			else {
				if (current.length() > currentmax.length()) {
					currentmax = current;
				}
				current = "";
			}
			i ++;
		}
		
		System.out.println(currentmax);
	}
}
