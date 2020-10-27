import java.util.Scanner;

/**
 * 
 * @author Науменко Георгій. Створено 25/10/2020. Завдання 6.3
 *
 */
public class task_6_3 {

	/**
	 * основний метод main завдання 6.3
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Введіть кількість стовпчиків");
		int n = input.nextInt();
		System.out.println("Введіть кількість рядків");
		int m = input.nextInt();
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				matrix[i][j] = input.nextInt();
			}
		}
		input.close();
		
		int maxi = 0, counter = 1;
		for(int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				if(j == n-1 & i != m-1) {
					if (matrix[i][j] < matrix[i+1][0]) {
						counter ++;
					}
					else {
						if (counter > maxi) {
							maxi = counter;
						}
						counter = 1;
					}
				}
				else if (j == n-1 & i == m-1) {
					if (counter > maxi) {
						maxi = counter;
					}
					counter = 1;
				}
				else {
					if (matrix[i][j] < matrix[i][j+1]) {
						counter ++;
					}
					else {
						if (counter > maxi) {
							maxi = counter;
						}
						counter = 1;
					}
				}
			}
		}
		System.out.println("Кількість: " + maxi);
		System.out.println("Naumenko, task 6.3");
	}
}
