import java.util.Scanner;

/**
 * 
 * @author Ќауменко √еорг≥й. —творено 25/10/2020. «авданн€ 6.2
 *
 */
public class task_6_2 {

	/**
	 * основний метод main завданн€ 6.2
	 * @param rags
	 */
	public static void main(String[] rags) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("¬вед≥ть к≥льк≥сть стовпчик≥в");
		int n = input.nextInt();
		System.out.println("¬вед≥ть к≥льк≥сть р€дк≥в");
		int m = input.nextInt();
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				matrix[i][j] = input.nextInt();
			}
		}
		System.out.println("¬вед≥ть к≥льк≥сть позиц≥й дл€ зсуву вправо: ");
		int k = input.nextInt();
		input.close();
		
		System.out.println("¬х≥дна матриц€:");
		showMatrix(matrix);
		for(int i = 0; i < m; i ++) {
			matrix[i] = rightCyc(matrix[i], k);
		}
		System.out.println("¬их≥дна матриц€:");
		showMatrix(matrix);
		
	}
	
	/**
	 * метод, що виводить матрицю на консоль
	 * @param matrix вх≥дна матриц€
	 */
	protected static void showMatrix(int[][] matrix) {
		String s = "";
		int m = matrix.length;
		int n = matrix[0].length;
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				if (j == n-1) {
					s += Integer.toString(matrix[i][j]) + " " + System.lineSeparator();
				}
				else {
					s += Integer.toString(matrix[i][j]) + " ";
				}
			}
		}
		System.out.println(s);
	}
	
	/**
	 * метод, що зд≥йснюЇ цикл≥чний зсув по масиву вправо
	 * @param arr масив
	 * @param k к≥льк≥сть позиц≥й, на €ку буде посунуто масив
	 * @return оброблений масив
	 */
	protected static int[] rightCyc(int[] arr, int k) {
		int n = arr.length;
		int s = n - k;
		int[] res = new int[n];
		for(int i = n - 1; i > s - 1; i --) {
			res[n - 1 - i] = arr[i];
		}
		for(int i = 0; i < s; i ++) {
			res[k + i] = arr[i];
		}
		return res;
	}
}
