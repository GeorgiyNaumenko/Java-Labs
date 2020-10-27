/**
 * 
 * @author Науменко Георгій
 * Створено 24/10/2020
 * класс, що описує структуру, яка дозволяє працювати с надзвичайно великими числами
 */
public class bigNum {
	
	/**
	 * массив цілих чисел, з яких складаєтсья десятковий запис числа
	 */
	int[] nums;
	
	/**
	 * конструктор 1
	 * @param nums масив дійсних чисел
	 */
	bigNum(int[] nums){
		
		this.nums = nums;
	}
	
	/**
	 * конструктор 2
	 * @param num рядок десяткового запису числа
	 */
	bigNum(String _num){
		
		int num = Integer.parseInt(_num);
		int l = (int) Math.ceil(Math.log10(num));
		int[] arr = new int[l];
		for(int i = 0; i < l; i++) {
			arr[i] = (num / (int) Math.pow(10, i)) % 10;
		}
		this.nums = arr;
	}
	
	/**
	 * метод довжини числа
	 * @return повертає довжину десяткового запису числа
	 */
	int len() {
		
		int l = this.nums.length;
		return l;
	}
	
	/**
	 * метод дозволяє додавати великі числа
	 * @param other інше велике число
	 * @return сумма великих чисел
	 */
	bigNum bigAdd(bigNum other) {
		
		int[] array1 = this.nums, array2 = other.nums;
		int l1 = array1.length, l2 = array2.length;
		int[] arr1, arr2;
		if (l2 > l1) {
			arr1 = array2.clone();
			arr2 = array1.clone();
		}
		else {
			arr1 = array1.clone();
			arr2 = array2.clone();
		}
		int lmax = Math.max(l1, l2), lmin = Math.min(l1, l2);
		int[] arr = new int[lmax+1];
		int current = 0;
		int buff = 0;
		for (int i = lmin-1; i > -1; i++) {
			current = arr1[lmin - lmax + i] + arr2[i] + buff;
			if(current > 9) {
				buff = 1;
			}
			else {
				buff = 0;
			}
			arr[lmin - lmax + i] = current%10;
		}
		if(lmax != lmin) {
			arr[lmin - lmax - 1] = arr1[lmin - lmax - 1] + buff;
		}
		if(lmax > lmin + 1) {
			for(int i = 0; i < lmin-lmax-1; i++) {
				arr[i] = arr1[i];
			}
		}
		
		if(arr[0] == 0) {
			int[] array = new int[lmax];
			for(int i = 0; i < lmax; i++) {
				array[i] = arr[i+1];
			}
			arr = array;
		}
		
		bigNum new_num = new bigNum(arr);
		
		return new_num;
	}
	
	/**
	 * дозволяє віднімати великі числа
	 * @param other інше велике число
	 * @return різниця великих чисел
	 */
	bigNum bigSubstract(bigNum other) {
		
		/*
		 * Здесь будет код
		 */
		
		return null;
	}
	
	/**
	 * виводить на консоль велике число
	 */
	void show() {
		
		String res = "";
		int l = this.len();
		for(int i = 0; i<l; i++) {
			res += Integer.toString(this.nums[i]);
		}
		System.out.println(res);
	}
}
