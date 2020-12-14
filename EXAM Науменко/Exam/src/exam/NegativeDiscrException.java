package exam;

public class NegativeDiscrException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a;
	private int b;
	private int c;
	
	NegativeDiscrException(int a_, int b_, int c_){
		a = a_;
		b = b_;
		c = c_;
	}
	
	@Override
	public String toString() {
		String s = "������������ ��������� " + Integer.toString(a) + "x^4 + " + Integer.toString(b) + "x^2 + " + Integer.toString(c);
		s += " ����� ������������� ������������, ������������� - �� ����� ������!";
		return s;
	}
}
