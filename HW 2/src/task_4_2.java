import java.util.Scanner;
import java.util.ArrayList;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 4.2
 *
 */
public class task_4_2 {

	/**
	 * основний метод main завдання 4.2
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList <String> a = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		String inp = "";
		int i = 0;
		while(true) {
			System.out.println("a["+i+"] = ");
			inp = input.nextLine();
			if (inp.equals("0")) {
				break;
			}
			i++;
			a.add(inp);
		}
		input.close();
		
		int l = a.size();
		int s = 0;
		for(int i1 = 0; i1 < l; i1++) {
			s += Integer.parseInt(a.get(i1));
		}
		
		System.out.println(s);
		System.out.println("Naumenko, task 4.2");
	}
}
