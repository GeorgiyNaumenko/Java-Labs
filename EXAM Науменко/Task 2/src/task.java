import java.util.Scanner;



/*
я ≤—№ ѕ–ќЅЋ≈ћ» ≤« ¬¬ќƒќћ «  ќЌ—ќЋ≤!!! NEXTLINE Ќ≈ ’ќ„≈ ѕ–»…ћј“» –яƒ ».
я јЅќ ¬»–≤Ў” ÷ё ѕ–ќЅЋ≈ћ”, јЅќ «–ќЅЋё ћќƒ»‘≤ ј÷≤ё ≤ ƒјЌ≤ Ѕ”ƒ”“№ „»“ј“»—№ « ‘ј…Ћ”.
Ќ≈ ƒ»¬Ћя„»—№ Ќј ÷≈,  Ћј— ABITURIENT ѕ–ј÷ё™ ѕ–ј¬»Ћ№Ќќ.
*/

/**
 * 
 * @author Ќауменко √еорг≥й. —творено 26/10/2020. «авданн€ 1.4
 *
 */
public class task {

	/**
	 * основний метод main
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		//System.out.println("¬вед≥ть к≥льк≥сть студент≥в:");
		//int n = input.nextInt();
		//System.out.println("¬вед≥ть к≥льк≥сть предмет≥в:");
		//int m = input.nextInt();
		int n = 1;
		Abiturient[] abiturients = new Abiturient[n];
		/*String name = "", second_name = "", last_name = "", adress = "", phone_number = "";
		for(int i = 1; i < n + 1; i ++) {
			System.out.println("¬вед≥ть ≥м'€ аб≥тур≥Їнта " + i + ":");
			name = input.nextLine();
			System.out.println("¬вед≥ть пр≥звище аб≥тур≥Їнта " + i + ":");
			second_name = input.nextLine();
			System.out.println("¬вед≥ть по-батьков≥ аб≥тур≥Їнта " + i + ":");
			last_name = input.nextLine();
			System.out.println("¬вед≥ть адресу аб≥тур≥Їнта " + i + ":");
			adress = input.nextLine();
			System.out.println("¬вед≥ть номер моб≥льного телефону аб≥тур≥Їнта " + i + ":");
			phone_number = input.nextLine();
			abiturients[i-1] = new Abiturient(name, second_name, last_name, adress, phone_number);
			for(int j = 1; j < m + 1; j ++) {
				System.out.println("¬вед≥ть оц≥нку " + j + " аб≥тур≥Їнта " + i + ":");
				abiturients[i-1].addPoint(input.nextInt());
			}
		}
		System.out.println("¬вед≥ть верхню межу сумми оц≥нок: ");
		int num = input.nextInt();
		System.out.println("¬вед≥ть к≥льк≥сть перших аб≥тур≥Їнт≥в: ");
		int _n = input.nextInt();*/
		
		String line = input.nextLine();
		input.close();
		String[] data = line.split(", ");
		abiturients[0] = new Abiturient(data[0], data[1], data[2], data[3], data[4]);
		int num = 250;
		int _n = 1;
		for(int i = 0; i < 5; i++){
			abiturients[0].addPoint(90);
		}
		
		Abiturient.showAbiturientsMeanPointIsSemiPass(abiturients);
		Abiturient.showAbiturientsPointsSumGraterThen(abiturients, num);
		Abiturient.showFirstAbiturientsWithHighestPointsSum(abiturients, _n);
		Abiturient.showNotNormalPointAbiturients(abiturients);
		
		System.out.println("Naumenko, task 1.4");
	}
}
