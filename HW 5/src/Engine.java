/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020
 *
 */

public class Engine {

	/**
	 * інкапсульовані поля
	 * доступ тільки через певні методи
	 * встановлюють властивості двигуна
	 */
	private int volume = 20000;
	private int maxRev = 40000;
	private int power = 5000;
	
	/**
	 * Конструктор
	 * @param _volume об'єм
	 * @param _maxRev максимальні обороти
	 * @param _power потужність
	 */
	Engine(int _volume, int _maxRev, int _power){
		volume = _volume;
		maxRev = _maxRev;
		power = _power;
	}
	
	/**
	 * Конструктор
	 */
	Engine(){
		
	}
	
	/**
	 * метод, що повертає об'єм двигуна
	 * @return об'єм
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * метод, що повертає максимальні обороти двигуна
	 * @return обороти
	 */
	public int getMaxRev() {
		return maxRev;
	}
	
	/**
	 * метод, що повертає потужність двигуна
	 * @return потужність
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * метод, що втсановлює об'єм двигуна
	 * @param _volume об'єм
	 */
	public void setVolume(int _volume) {
		volume = _volume;
	}
	
	/**
	 * метод, що встановлює максимальні обороти двигуна
	 * @param _maxRev обороти
	 */
	public void setMaxRev(int _maxRev) {
		maxRev = _maxRev;
	}
	
	/**
	 * метод, що встановлює потужність двигуна
	 * @param _power потужність
	 */
	public void setPower(int _power) {
		power = _power;
	}
}
