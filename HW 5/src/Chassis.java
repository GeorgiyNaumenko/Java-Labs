/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020
 *
 */

public class Chassis {

	/**
	 * інкапсульовані поля
	 * доступ тільки через певні методи
	 * встановлюють властивості шассі
	 */
	private double weight = 100;
	private double time_in = 10;
	private double time_out = 15;
	private boolean is_out = false;
	
	/**
	 * Конструктор
	 * @param _weight вага шассі
	 * @param _time_in час спуску шассі
	 * @param _time_out час підйому шассі
	 */
	Chassis(double _weight, double _time_in, double _time_out){
		weight = _weight;
		time_in = _time_in;
		time_out = _time_out;
		is_out = false;
	}
	
	/**
	 * метод, що повертає вагу шассі
	 * @return вага
	 */
	protected double getWeight() {
		return weight;
	}
	
	/**
	 * метод, що повертає час, за який дані шассі підіймаються в літак
	 * @return час
	 */
	protected double getTimeIn() {
		return time_in;
	}
	
	/**
	 * метод, що повертає час спуску шассі
	 * @return час
	 */
	protected double getTimeOut() {
		return time_out;
	}
	
	/**
	 * метод, що здійснює спуск шассі
	 */
	protected void chassisOut() {
		if (!is_out) {
			is_out = true;
		}
	}
	
	/**
	 * метод, що здійснює підйом шассі
	 */
	protected void chassisIn() {
		if (is_out) {
			is_out = true;
		}
	}
}
