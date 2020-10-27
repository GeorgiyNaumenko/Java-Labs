import java.util.Scanner;
import java.util.Arrays;

/**
 * 
 * @author Íàóìåíêî Ãåîğã³é. Ñòâîğåíî 25/10/2020. Çàâäàííÿ 5.1
 *
 */
public class task_5_1 {

	/**
	 * îñíîâíèé ìåòîä main çàâäàííÿ 5.1
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		input.close();
		String[] nums = line.split(" ");
		int[] int_nums = Arrays.asList(nums).stream().mapToInt(Integer::parseInt).toArray();
		int[] array = bubble_sort(int_nums);
		System.out.println("Ìàêñèìóì: " + array[array.length-1]);
		System.out.println("Ì³í³ìóì: " + array[0]);
		System.out.println("Naumenko, task 5.1");
	}
	
	/**
	 * Ìåòîä, ùî çä³éñíşº áóëüáàøêîâå ñòîğòóâàííÿ ìàññèâó ö³ëèõ ÷èñåë
	 * @param arr âõ³äíèé ìàññèâ
	 * @return â³äñîğòîâàíèé ìàññèâ
	 */
	private static int[] bubble_sort(int[] arr){
		
		int n = arr.length;
		for(int pass_num = n-1; pass_num>0; pass_num--) {
			for(int i = 0; i < pass_num; i++) {
				if(arr[i] > arr[i+1]) {
					int t = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = t;
				}
			}
		}
		return arr;
	}
}
