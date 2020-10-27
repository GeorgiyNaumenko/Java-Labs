/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020
 *
 */
public class Wing {

	/**
	 * інкапсульовані поля
	 * доступ тільки через певні методи
	 * встановлюють властивості крила
	 */
	private double wingLengths = 10.0;
	private boolean right = true, left = false;
	private double subWingAngle = 15;
	
	/**
	 * Конструктор
	 * @param _wingLengths довжина крила
	 * @param side праве чи ліве крило
	 */
	Wing(double _wingLengths, String side){
		if(side.equals("right")) {
			right = true;
			left = false;
		}
		else if (side.equals("left")) {
			right = false;
			left = true;
		}
		wingLengths = _wingLengths;
	}
	
	/**
	 * метод, що встановлює, чи є крило правим
	 * @return чи є крило правим
	 */
	protected boolean isRight() {
		return right;
	}
	
	/**
	 * метод, що встановлює, чи є крило лівим
	 * @return чи є крило лівим
	 */
	protected boolean isLeft() {
		return left;
	}
	
	/**
	 * метод, що змінює крило підкрильників
	 * @param _subWingAngle кут
	 */
	protected void changeAngle(double _subWingAngle) {
		subWingAngle = _subWingAngle;
	}
	
	/**
	 * метод, що повертає кут підкрильників
	 * @return кут
	 */
	protected double getAngle() {
		return subWingAngle;
	}
	
	/**
	 * метод, що повертає довжину крила
	 * @return довжина
	 */
	protected double getLength() {
		return wingLengths;
	}
}
