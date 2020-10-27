import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 2.1
 *
 */
public class task_2_1 {
	
	/**
	 * 
	 * @param args
	 * основний метод main завдання номер 2.1
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String arr = input.nextLine();
		input.close();
		String[] nums = arr.split(" ");
		int n = Integer.parseInt(nums[0]), m = Integer.parseInt(nums[1]);
		String n1 = Integer.toBinaryString(n);
		int l = n1.length();
		if(n1.charAt(m-1) == '1') {
			n -= (int) Math.pow(2, l-m);
		}
		else {
			n += (int) Math.pow(2, l-m);
		}
		System.out.println(n);
	}
}
