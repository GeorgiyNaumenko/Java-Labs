import java.util.Scanner;
import java.util.Arrays;

/**
 * 
 * @author Науменко Георгій. Створено 24/10/2020. Завдання 3.3
 *
 */
public class task_3_3 {
	
	/**
	 * метод встановлює, чи є символ цифрою
	 * @param array вхідна строка (вже навіть не розумію навіщо вона)
	 * @param c символ
	 * @return чи є символ цифрою
	 */
	private static boolean containsNumber(String array, char c) {
		
		String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		if (Arrays.stream(nums).anyMatch(String.valueOf(c)::equals)) {
			return true;
		}
		return false;
	}
	
	/**
	 * основний метод main завдання 3.3
	 * @param args
	 */
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String day = "", mon = "", year = "";
		input.close();
		int l = line.length();
		String date = "", correctdate = "";
		int i = 0;
		boolean flag = false;
		while(true) {
			if(i >= l) {
				break;
			}
			if (containsNumber(line, line.charAt(i))) {
				while (containsNumber(line, line.charAt(i))) {
					mon += String.valueOf(line.charAt(i));
					i ++;
					if(i >= l) {
						break;
					}
				}
				flag = true;
				break;
			}
			if (flag) {
				break;
			}
			i ++;
		}
		flag = false;
		while(true) {
			if(i >= l) {
				break;
			}
			if (containsNumber(line, line.charAt(i))) {
				while (containsNumber(line, line.charAt(i))) {
					day += String.valueOf(line.charAt(i));
					i ++;
					if(i >= l) {
						break;
					}
				}
				flag = true;
				break;
			}
			if (flag) {
				break;
			}
			i ++;
		}
		flag = false;
		while(true) {
			if(i >= l) {
				break;
			}
			if (containsNumber(line, line.charAt(i))) {
				while (containsNumber(line, line.charAt(i))) {
					year += String.valueOf(line.charAt(i));
					i ++;
					if(i >= l) {
						break;
					}
				}
				flag = true;
				break;
			}
			if (flag) {
				break;
			}
			i ++;
		}
		flag = false;
		
		String[] month = {"січня", "лютого", "березня", "квітня", "травня", "червня", "липня", 
				"серпня", "вересня", "жовтня", "листопада", "грудня"};
		
		int nday = Integer.parseInt(day);
		int nmon = Integer.parseInt(mon);
		int nyear = Integer.parseInt(year);
		if ((nday >= 32 | nday <=0) | (nmon >= 13 | nmon <=0) | (nyear >= 2101 | nyear <=1999)) {
			System.out.println("Введена дата некорректна!!!");
		}
		else {
			date = date + day + " " + month[Integer.parseInt(mon) -1] + " " + year + " року.";
			correctdate = correctdate + mon + "." + day + "." + year;
			if (!correctdate.equals(line)) {
				System.out.println("Некорректний формат дати.");
				System.out.println("Корректний формат дати: " + correctdate);
				System.out.println("Дата: " + date);
			}
			else {
				System.out.println("Дата: " + date);
			}
		}
		System.out.println("Naumenko,  task 3.3");
	}
}
