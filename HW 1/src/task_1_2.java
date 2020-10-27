import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 1.2
 *
 */
public class task_1_2 {
	
	/**
	 * 
	 * @param args
	 * основній метод main завдання номер 1.2
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String n, m;
		int n1, m1;
		n = input.nextLine();
		m = input.nextLine();
		input.close();
		n1 = Integer.parseInt(n);
		m1 = Integer.parseInt(m);
		System.out.println("Logarithms:");
		int lon = (int)Math.ceil(Math.log10(n1));
		int lom = (int)Math.ceil(Math.log10(m1));
		System.out.println(lon + ", " + lom);
		System.out.println("Strings:");
		int l_n = n.length(), l_m = m.length();
		System.out.println(l_n + ", " + l_m);
		
		@SuppressWarnings("deprecation")
		double dn = new Double(lon);
		@SuppressWarnings("deprecation")
		double dm = new Double(lom);
		System.out.println("Medium harmonic:");
		double harm = 2 / ((1/dn) + (1/dm));
		System.out.printf("%.2f", harm);
	}
}
