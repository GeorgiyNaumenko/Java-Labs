import java.util.ArrayList;

/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020
 *
 */
public class Abiturient {

	/**
	 * поля, що викроистовуються.
	 * всі мають модифікатор доступу private для інкапсуляції.
	 * якщо потрібно напряму дістати поле, потрібно для цього описати певний метод.
	 */
	private String name = "", second_name = "", last_name = "";
	private String adress = "", phone_number = "";
	private ArrayList <String> points = new ArrayList <>();
	private static int normPoint = 60, semiPassPoint = 59;
	
	/**
	 * Конструктор
	 * @param _name ім'я абітурієнта
	 * @param _second_name прізвище абітурієнта
	 * @param _last_name по батькові абітурієнта
	 * @param _adress адреса абітурієнта
	 * @param _phone_number мобільний телефон абітурієнта
	 */
	Abiturient (String _name, String _second_name, String _last_name, String _adress, String _phone_number){
		name = _name;
		second_name = _second_name;
		last_name = _last_name;
		adress = _adress;
		phone_number = _phone_number;
	}
	
	/**
	 * метод для зміни задовільної оцінки
	 * @param newPoint нова задовільна оцінка
	 */
	protected static void setNormPoint(int newPoint) {
		normPoint = newPoint;
	}
	
	/**
	 * метод для зміни напівпрохідної середньої оцінки
	 * @param newPoint
	 */
	protected static void setSemiPassPoint(int newPoint) {
		semiPassPoint = newPoint;
	}
	
	/**
	 * метод, що встановлює, чи має абітурієнт незадовільну оцінку
	 * @return чи має абітурієнт незадовільну оцінку
	 */
	protected boolean hasLessThanNormPoint() {
		int n = points.size();
		for(int i = 0; i < n; i ++) {
			if (Integer.parseInt(points.get(i)) < normPoint) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * метод, що встановлює чи є сумма балів студента більшою за задану
	 * @param num заданий бал
	 * @return є сумма балів студента більшою за задану
	 */
	protected boolean isPointsSumGraterThen(double num) {
		if(pointsSum() > num) {
			return true;
		}
		return false;
	}
	
	/**
	 * метод, що повертає суму балів абітурієнта
	 * @return сума балів
	 */
	protected int pointsSum() {
		int n = points.size();
		int s = 0;
		for(int i = 0; i < n; i ++) {
			s += Integer.parseInt(points.get(i));
		}
		return s;
	}
	
	/**
	 * метод, що встановлює чи є середній бал напівпрохідним
	 * @return чи є середній бал напівпрохідним
	 */
	protected boolean meanPointIsSemiPass() {
		if(((double) pointsSum()) / ((double) points.size()) == (double) semiPassPoint) {
			return true;
		}
		return false;
	}
	
	/**
	 * інкапсульований метод, що визначає серед списку абітурієнтів тих, в кого є незадовільні оцінки
	 * @param abiturients список абітурієнтів
	 * @return список тих, в кого є оцінка менша ніж задовільна
	 */
	private static Abiturient[] getNotNormalPointList(Abiturient[] abiturients) {
		int n = abiturients.length;
		ArrayList <Abiturient> res = new ArrayList<>();
		for(int i = 0; i < n; i ++) {
			if (abiturients[i].hasLessThanNormPoint()) {
				res.add(abiturients[i]);
			}
		}
		int m = res.size();
		Abiturient[] outres = new Abiturient[m];
		if (m < 1) {
			return outres;
		}
		for(int i = 0; i < m; i ++) {
			outres[i] = res.get(i);
		}
		return outres;
	}
	
	/**
	 * метод, що додає оцінку абітурієнту
	 * @param newPoint нова оцінка, ціле число
	 */
	protected void addPoint(int newPoint) {
		points.add(Integer.toString(newPoint));
	}
	
	/**
	 * метод, що додає оцінку абітурієнту
	 * @param newPoint нова оцінка, строка
	 */
	protected void addPoint(String newPoint) {
		points.add(newPoint);
	}
	
	/**
	 * інкапсульований метод, який створює рядок з оцінок
	 * @return рядок, що містить усі оцінки
	 */
	private String getPointsString() {
		String s = "";
		int n = points.size();
		for(int i = 0; i < n; i ++) {
			if (i == n-1) {
				s += points.get(i);
			}
			else {
				s += points.get(i) + ", ";
			}
		}
		return s;
	}
	
	/**
	 * перевантажений метод toString(), щоб вивести дані про абітурієнта на консоль
	 */
	public String toString(){
		String s = getPointsString();
		return "Абітурієнт " + second_name + " " + name + " " + last_name + ", адреса: "
				+ adress + ", " + phone_number + ", оцінки: " + s + ".";
	}
	
	/**
	 * метод, що виводить на консоль тих абітурієнтів, які мають незадовільну оцінку
	 * @param abiturients список абітурієнтів
	 */
	protected static void showNotNormalPointAbiturients(Abiturient[] abiturients) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getNotNormalPointList(abiturients);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		int n = to_show.length;
		System.out.println("Список абітурієнтів, що мають незадовільні оцінки:");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
	
	/**
	 * інкапсульований метод, що встановлює, які абітурієнти мають сумму балів вищу за задану
	 * @param abiturients список абітурієнтів
	 * @param num заданий бал
	 * @return список тих, в кого сума балів вища за задану
	 */
	private static Abiturient[] getAbiturientsPointsSumGraterThen(Abiturient[] abiturients, double num) {
		ArrayList <Abiturient> res = new ArrayList<>();
		int n = abiturients.length;
		for(int i = 0; i < n; i ++) {
			if (abiturients[i].isPointsSumGraterThen(num)) {
				res.add(abiturients[i]);
			}
		}
		int m = res.size();
		Abiturient[] outres = new Abiturient[m];
		if (m < 1) {
			return outres;
		}
		for(int i = 0; i < n; i ++) {
			outres[i] = res.get(i);
		}
		return outres;
	}
	
	/**
	 * метод, що виводить на консоль тих абітурієнтів, що мають суму балів вищу за задану
	 * @param abiturients список абітурієнтів
	 * @param num заданий бал
	 */
	protected static void showAbiturientsPointsSumGraterThen(Abiturient[] abiturients, double num) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getAbiturientsPointsSumGraterThen(abiturients, num);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		int n = to_show.length;
		System.out.println("Список абітурієнтів, що мають сумму балів вище за " + num + ":");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
	
	/**
	 * інкапсульований метод, що встановлює, які абітурієнти мають напівпрохідний середній бал
	 * @param abiturients список абітурієнтів
	 * @return список тих абітурієнтів, які мають напівпрохідний середній бал
	 */
	private static Abiturient[] getAbiturientsMeanPointIsSemiPass(Abiturient[] abiturients) {
		ArrayList <Abiturient> res = new ArrayList<>();
		int n = abiturients.length;
		for(int i = 0; i < n; i ++) {
			if (abiturients[i].meanPointIsSemiPass()) {
				res.add(abiturients[i]);
			}
		}
		int m = res.size();
		Abiturient[] outres = new Abiturient[m];
		if (m < 1) {
			return outres;
		}
		for(int i = 0; i < n; i ++) {
			outres[i] = res.get(i);
		}
		return outres;
	}
	
	/**
	 * метод, що виводить на консоль тих абітурієнтів, які мають середній напівпрохідний бал
	 * @param abiturients
	 */
	protected static void showAbiturientsMeanPointIsSemiPass(Abiturient[] abiturients) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getAbiturientsMeanPointIsSemiPass(abiturients);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		int n = to_show.length;
		System.out.println("Список абітурієнтів, що мають напівпрохідний середній бал:");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
	
	/**
	 * інкапсульований метод, що проводить бульбашкове сортування по списку абітурієнтів
	 * сортує по порятку спадання сумми балів
	 * @param abiturients список абітурієнтів
	 * @return відсортований список абітурієнтів
	 */
	private static Abiturient[] bubbleSortBySum(Abiturient[] abiturients) {
		int n = abiturients.length;
		for(int pass_num = n-1; pass_num>0; pass_num--) {
			for(int i = 0; i < pass_num; i++) {
				if(abiturients[i].pointsSum() < abiturients[i+1].pointsSum()) {
					Abiturient t = abiturients[i];
					abiturients[i] = abiturients[i+1];
					abiturients[i+1] = t;
				}
			}
		}
		return abiturients;
	}
	
	/**
	 * інкапсульований метод, що встановлює перших абітурієнтів з найвищою суммою балів
	 * @param abiturients список абітурієнтів
	 * @param n кількість перших абітурієнтів
	 * @return список з перших n абітурієнтів
	 */
	private static Abiturient[] getFirstAbiturientsWithHighestPointsSum(Abiturient[] abiturients, int n) {
		Abiturient[] sorted = Abiturient.bubbleSortBySum(abiturients);
		Abiturient[] outres = new Abiturient[n];
		for(int i = 0; i < n; i ++) {
			outres[i] = sorted[i];
		}
		return outres;
	}
	
	/**
	 * метод, що виводить на консоль перших абітурієнтів з найвищою сумою балів
	 * @param abiturients список абітурієнтів
	 * @param n кількість перших абітурієнтів
	 */
	protected static void showFirstAbiturientsWithHighestPointsSum(Abiturient[] abiturients, int n) {
		if (abiturients.length == 0) {
			System.out.println("NOOO");
			return;
		}
		Abiturient[] to_show = getFirstAbiturientsWithHighestPointsSum(abiturients, n);
		if (to_show.length == 0) {
			System.out.println("NOOO");
			return;
		}
		System.out.println("Список перших " + n + " абітурієнтів, що мають найвищу суму балів:");
		for(int i = 0; i < n; i ++) {
			System.out.println(to_show[i]);
		}
	}
}