import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 4.1
 *
 */
public class task_4_1 {
	
	/**
	 * метод, що обчислює факторіал циклом
	 * @param n вхідне число
	 * @return факторіал вхідного числа
	 */
	private static int loop_factorial(int n) {
		
		int f = 1;
		for(int i = 1; i < n + 1; i ++) {
			f *= i;
		}
		return f;
	}
	
	/**
	 * метод, що обчислює факторіал рекурсією
	 * @param n вхідне число
	 * @return факторіал вхідного числа
	 */
	private static int recursion_factorial(int n) {
		
		if (n == 1 | n == 0) {
			return 1;
		}
		else {
			return n * recursion_factorial(n-1);
		}	
	}
	
	/**
	 * основний метод main завдання 4.1
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double a = input.nextDouble();
		input.close();
		int b = (int) a;
		double c = (double) b;
		boolean eq = (a == c);
		if(eq) {
			System.out.println("Введене число є цілим!");
			//long t1 = System.currentTimeMillis();
			int lf = loop_factorial(b);
			//long t2 = System.currentTimeMillis();
			//long t3 = System.currentTimeMillis();
			int rf = recursion_factorial(b);
			//long t4 = System.currentTimeMillis();
			//long t_lf = t2 - t1, t_rf = t4 - t3;
			System.out.println("Значення факторіалів:");
			//System.out.println("Циклічний алгоритм - " + lf + " з часом " + t_lf);
			//System.out.println("Рекурсивний алгоритм - " + rf + " з часом " + t_rf);
			System.out.println("Циклічний алгоритм - " + lf);
			System.out.println("Рекурсивний алгоритм - " + rf);
			
		}
		else {
			System.out.println("Введене число не є цілим!");
		}
		System.out.println("Naumenko, task 4.1");
	}
}
