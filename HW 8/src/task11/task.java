package task11;

import java.util.Scanner;

public class task {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		input.close();
		int l = s.length();
		char c = 'c';
		String current = "", currentmax = "";
		int i = 0, start = 0, end = 0, start_max = 0, end_max = 0;
		
		while (i < l) {
			c = s.charAt(i);
			if (current.length() == 0) {
				current += Character.toString(c);
				start = i;
				end = i;
			}
			else if ((c == current.charAt(current.length()-1))){
				current += Character.toString(c);
				end ++;
			}
			else {
				if (current.length() > currentmax.length()) {
					currentmax = current;
					start_max = start;
					end_max = end;
				}
				current = "";
				start = 0;
				end = 0;
			}
			i ++;
		}
		
		StringBuilder st = new StringBuilder(s);
		st.delete(start_max-1, end_max+1);
		System.out.println(st);
	}
}
