import java.util.Scanner;
import java.math.BigInteger;


/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 2.7
 *
 */
public class task_2_7 {
	
	/**
	 * 
	 * @param args
	 * основний метод main завдання 2.7
	 * 
	 * в планах було викроистовувати власну структуру bigNum, але поки що не можу
	 * визначити метод Substract (пізніше дороблю його), тому поки що використовується 
	 * вбудована структура.
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		input.close();
		String[] sline = line.split(", ");
		BigInteger num1 = new BigInteger(sline[0]), num2 = new BigInteger(sline[1]);
		BigInteger n = num1.add(num2), m = num1.subtract(num2);
		System.out.println("Сумма чисел: " + n);
		System.out.println("разность чисел: " + m);
	}
}
