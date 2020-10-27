import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020. Завдання 4.3
 *
 */
public class task_4_3 {

	/**
	 * основний метод main завдання 4.3
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String r = "";
		System.out.println("Введіть маршрут з аеропортами через пропуск:");
		r = input.nextLine();
		String[] rt = r.split(" ");
		System.out.println("Введіть кількість аеропортів, які треба пройти");
		int k = input.nextInt();
		input.close();
		Plane plane = new Plane(rt);
		for(int i = 0; i < k; i ++) {
			plane.fly();
		}
		
		System.out.println("Naumenko, task 4.3");
	}
}
