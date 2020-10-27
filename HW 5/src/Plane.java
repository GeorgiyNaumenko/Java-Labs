import java.util.ArrayList;

/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020.
 * класс наслідується від двигуна, бо по суті, літак має так само ті властивості, що й двигун
 */
public class Plane extends Engine {

	/**
	 * інкапсульовані поля
	 * доступ тільки через певні методи
	 * встановлюють властивості двигуна
	 */
	private ArrayList <String> route = new ArrayList<>();
	private int maxSpeed = 800;
	private int currentIndex = 0;
	private int routeLength = route.size();
	
	/**
	 * Конструктор
	 * @param _volume об'єм
	 * @param _maxRev максимальні обороти
	 * @param _power потужність
	 * @param _route маршрут (структура ArrayList)
	 * @param _maxSpeed максимальна швидкість
	 */
	Plane(int _volume, int _maxRev, int _power, ArrayList <String> _route, int _maxSpeed) {
		super(_volume, _maxRev, _power);
		route = _route;
		maxSpeed = _maxSpeed;
	}
	
	/**
	 * Конструктор
	 * @param _volume об'єм
	 * @param _maxRev максимальні обороти
	 * @param _power потужність
	 * @param _route маршурт (Структура String[])
	 * @param _maxSpeed максимальна швидкість
	 */
	Plane(int _volume, int _maxRev, int _power, String[] _route, int _maxSpeed) {
		super(_volume, _maxRev, _power);
		maxSpeed = _maxSpeed;
		ArrayList <String> arr = new ArrayList<>();
		int l = _route.length;
		for(int i = 0; i < l; i ++) {
			arr.add(_route[i]);
		}
		route = arr;
	}
	
	/**
	 * Конструктор
	 * @param _route маршрут (структура String[])
	 */
	Plane(String[] _route){
		super();
		ArrayList <String> arr = new ArrayList<>();
		int l = _route.length;
		for(int i = 0; i < l; i ++) {
			arr.add(_route[i]);
		}
		route = arr;
	}
	
	/**
	 * Конструктор
	 * @param _route маршрут (структура Arraylist)
	 */
	Plane (ArrayList <String> _route){
		super();
		route = _route;
	}

	/**
	 * метод, що повертає максимальну швидкість
	 * @return максимальна швидкість
	 */
	protected int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 * метод, що повертає маршрут
	 * @return маршрут
	 */
	protected ArrayList <String> getRoute() {
		return route;
	}
	
	/**
	 * перевантажений метод toString(). Вивиодить на консоль маршрут
	 */
	public String toString() {
		String s = "";
		for(int i = 0; i < routeLength; i ++) {
			s += route.get(i);
		}
		return s;
	}
	
	/**
	 * метод, що додає аеропорт до маршруту
	 * @param place аеропорт
	 */
	protected void addToRoute(String place) {
		route.add(place);
	}
	
	/**
	 * метод, що здійснює переліт від поточного аеропорту до наступного
	 */
	protected void fly() {
		if (!isOver()) {
			System.out.println("Вилетів з аеропорту " + route.get(currentIndex));
			currentIndex ++;
			System.out.println("Прибув в аеропорт " + route.get(currentIndex));
		}
		else {
			System.out.println("Маршрут завершено");
		}
	}
	
	/**
	 * метод, що повертає назву поточного аеропорта
	 * @return поточний аеропорт
	 */
	protected String getCurrentPlace() {
		return route.get(currentIndex);
	}
	
	/**
	 * метод, що встановлює, чи завершив літак маршрут
	 * @return чи завершено маршрут
	 */
	protected boolean isOver() {
		if (currentIndex == routeLength - 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * метод, що повертає довжину маршруту
	 * @return кількість аеропортів в маршруті
	 */
	protected int getRouteLength() {
		return routeLength;
	}
}
