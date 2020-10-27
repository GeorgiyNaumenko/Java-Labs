import java.util.Scanner;
import java.util.Arrays;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 4.4
 *
 */
public class task {
	
	/**
	 * 
	 * @param args
	 * основний класс main завдання 4.4
	 */
	public static void main(String[] args) {
		int counter = 0;
		String numss;
		String[] nums;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter elements: ");
		String delimeter = ", ";
		numss = input.nextLine();
		input.close();
		long t1 = System.currentTimeMillis();
		nums = numss.split(delimeter);
		int[] int_nums = Arrays.asList(nums).stream().mapToInt(Integer::parseInt).toArray();
		int i = 0;
		while(true) {
			if (int_nums[i+1] == 0) {
				break;
			}
			if (int_nums[i] * int_nums[i+1] < 0) {
				counter ++;
			}
			i++;
		}
		long t2 = System.currentTimeMillis();
		long t = t2 - t1;
		System.out.println(counter + " times");
		System.out.println("Naumenko, task 4.4");
		System.out.println("Time: " + t);
	}
}
