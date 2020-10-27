import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 4.7
 *
 */
public class task_4_7 {
	
	/**
	 * метод, що допомагає обчислити значення факторіалу натурального числа
	 * @param n число, факторіал якого обраховується
	 * @return факторіал числа
	 */
	private static int factorial(double n) {
		
		int f = 1;
		for(int i = 1; i < n + 1; i ++) {
			f *= i;
		}
		return f;
	}

	/**
	 * основний метод main завдання 4.7
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Ввеідть точність:");
		double eps = input.nextDouble();
		System.out.println("Ввеідть точку:");
		double x = input.nextDouble();
		input.close();
		
		double res = 1.0, inc = x;
		double count = 1.0;
		while(Math.abs(inc) > eps) {
			inc = Math.pow(x, count)/ factorial(count);
			res += inc;
			count ++;
		}
		
		System.out.println(res);
	}
}
