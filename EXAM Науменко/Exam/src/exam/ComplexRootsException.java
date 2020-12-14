package exam;

public class ComplexRootsException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ComplexRootsException(){
	}
	
	@Override
	public String toString() {
		String s = "Уравнение не имеет корней в действительных числах!";
		return s;
	}
}
