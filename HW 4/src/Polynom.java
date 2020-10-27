import java.util.ArrayList;

/**
 * 
 * @author Науменко Георгій. Створено 26/10/2020.
 *
 */
public class Polynom {

	/**
	 * поля, що задають многочлен
	 * інкапсульовані, доступ до них поза цим класом можливий лише через відповідні методи
	 */
	private int deg = 0;
	private int[] coefs = null;
	
	/**
	 * Конструктор
	 * @param coefs_ об'єкт ArrayList, коефіцієнти многочлена
	 */
	Polynom (ArrayList<String> coefs_){
		deg = coefs_.size() - 1;
		int[] coefs = new int[deg];
		for(int i = 0; i < deg; i ++) {
			coefs[i] = Integer.parseInt(coefs_.get(i));
		}
	}
	
	/**
	 * Конструктор
	 * @param coefs_ масив цілих чисел, коефіцієнти
	 */
	Polynom(int[] coefs_){
		deg = coefs_.length - 1;
		coefs = coefs_;
	}
	
	/**
	 * метод, що встановлює, чи є многочлен тотожним нулем
	 * @return чи є многочлен тотожним нулем
	 */
	protected boolean isZero() {
		if(deg == 0 & coefs[0] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * статичний метод, що встановлює, чи є многочлен нулем
	 * @param g многочлен
	 * @return чи є цей многочлен нулем
	 */
	protected static boolean isZero(Polynom g) {
		if(g.deg == 0 & g.coefs[0] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * метод, що додає 2 многочлени
	 * @param f перший многочлен
	 * @param g другий многочлен
	 * @return сума многочленів
	 */
	protected static Polynom polySum(Polynom f, Polynom g) {
		int fd = f.deg, gd = g.deg;
		int deg = Math.max(fd, gd);
		int _deg = Math.min(fd, gd);
		int[] coefs_ = new int[deg + 1];
		for(int i = 0; i < _deg + 1; i++) {
			coefs_[deg - i] = f.coefs[fd - i] + g.coefs[gd - i];
		}
		if (fd > gd) {
			for(int i = 0; i < deg - _deg; i ++) {
				coefs_[i] = f.coefs[i];
			}
		}
		else {
			for(int i = 0; i < deg - _deg; i ++) {
				coefs_[i] = g.coefs[i];
			}
		}
		return new Polynom(coefs_);
	}
	
	/**
	 * метод, що додає 2 многочлени зі списку
	 * @param polynoms масив многочленів
	 * @param i індекс першого многочлена
	 * @param j індекс другого многочлена
	 * @return сума цих двох многочленів
	 */
	protected static Polynom sumOfTwoPolynoms(Polynom[] polynoms, int i, int j) {
		return Polynom.polySum(polynoms[i-1], polynoms[j-1]);
	}
	
	/**
	 * метод, що додає усі многочлени з набору многочленів
	 * @param polynoms масив многочленів
	 * @return сума всіх многочленів з масиву
	 */
	protected static Polynom sumOfAllPolynoms(Polynom[] polynoms) {
		int l = polynoms.length;
		for(int i = 2; i < l + 1; i ++) {
			polynoms[0] = Polynom.sumOfTwoPolynoms(polynoms, 1, i);
		}
		return polynoms[0];
	}
	
	/**
	 * перевантажений метод toString()
	 * виводить на консоль многочлен
	 */
	public String toString() {
		String s = "";
		
		if (deg > 1) {
			s += Integer.toString(coefs[0]) + "x^" + Integer.toString(deg);
		}
		else if(deg == 1) {
			s += Integer.toString(coefs[0]) + "x";
			return s;
		}
		else {
			return Integer.toString(coefs[0]);
		}
		
		for(int i = 1; i < deg + 1; i ++) {
			if (i == deg - 1) {
				if(coefs[i] > 0) {
					s += " + " + Integer.toString(coefs[i]) + "x";
				}
				else {
					s += " - " + Integer.toString(-coefs[i]) + "x";
				}
			}
			if(i == deg) {
				if(coefs[i] > 0) {
					s += " + " + Integer.toString(coefs[i]);
				}
				else {
					s += " - " + Integer.toString(-coefs[i]);
				}
			}
			else {
				if (coefs[i] != 0 & i < deg - 1) {
					if(coefs[i] > 0) {
						s += " + " + Integer.toString(coefs[i]) + "x^" + Integer.toString(deg - i);
					}
					else {
						s += " - " + Integer.toString(-coefs[i]) + "x^" + Integer.toString(deg - i);
					}
				}
			}
		}
		return s;
	}
}
