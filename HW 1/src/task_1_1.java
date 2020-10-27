import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 1.1
 * 
 * 
 * 
 */
public class task_1_1 {
	
	/**
	 * 
	 * @param args
	 * основний метод main завдання номер 1.1
	 */
	public static void main(String[] args) {
		System.out.println("Enter Your Name");
		String s;
		Scanner input = new Scanner(System.in);
		s = input.nextLine();
		input.close();
		System.out.println("Hello, " + s);
	}
}
