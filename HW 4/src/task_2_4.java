import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020. Завдання 2.4
 *
 */
@SuppressWarnings("unused")
public class task_2_4 {

	/**
	 * основний метод main завдання 2.4
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("Введіть кількість многочленів: ");
		int n = input.nextInt();
		Polynom[] polynoms = new Polynom[n];
		System.out.println("Введіть коефіцієнти многочленів (перш вводяться найвищі степені):");
		String line = "";
		for(int i = 0; i < n; i ++) {
			line = input.nextLine();
			polynoms[i] = new Polynom(Arrays.asList(line).stream().mapToInt(Integer::parseInt).toArray());
		}
		input.close();
		Polynom sum = Polynom.sumOfAllPolynoms(polynoms);
		System.out.println(sum);
		*/
		
		int[] cof1 = {2, 2, -1, -4, 5};
		int[] cof2 = {6, 3, -5, -3, 2, 0};
		int[] cof3 = {-10, -2, 5, 2, 0, 0, 0};
		Polynom poly1 = new Polynom(cof1);
		Polynom poly2 = new Polynom(cof2);
		Polynom poly3 = new Polynom(cof3);
		Polynom[] polynoms = {poly1, poly2, poly3};
		Polynom sum = Polynom.sumOfAllPolynoms(polynoms);
		System.out.println(sum);
		
		System.out.println("Naumenko, task 2.4");
	}
}
