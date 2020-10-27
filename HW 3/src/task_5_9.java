import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 25/10/2020. Завдання 5.9
 *
 */
public class task_5_9 {
	
	/**
	 * метод, що встановлює, чи є число паліндромом
	 * @param num число у вигляді строки
	 * @return чи є число паліндромом
	 */
	private static boolean is_palin(String num) {
		boolean ans = false;
		int k = num.length(), counter = 0;
		int k1;
		if (k % 2 == 0) {
			k1 = (k - 1)/2;
		}
		else {
			k1 = k/2;
		}
		for(int i = 0; i < k1; i++) {
			if (num.charAt(i) == num.charAt(k - i - 1)) {
				counter ++;
			}
		}
		if (counter == k1) {
			ans = true;
		}
		return ans;
	}
	
	/**
	 * основний метод main завдання 5.9
	 * @param args
	 */
	public static void main(String[] args) {
		
		int counter = 0;
		String current = null;
		String numss;
		String[] nums;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter elements: ");
		String delimeter = ", ";
		numss = input.nextLine();
		input.close();
		long t1 = System.currentTimeMillis();
		nums = numss.split(delimeter);
		int l = nums.length;
		for(int i = 0; i < l; i++) {
			if (is_palin(nums[i])) {
				counter ++;
				current = nums[i];
			}
			if (counter == 2) {
				System.out.println(current);
				return;
			}
		}
		long t2 = System.currentTimeMillis();
		long t = t2-t1;
		System.out.println(current);
		System.out.println("Naumenko, task 5.9");
		System.out.println("Time: " + t);
	}
}
