package task_4;

import java.util.ArrayList;

/**
 * 
 * @author �������� ������. �������� 26/10/2020.
 * ��������� ��������� �� ��� ����������, � ���� ����� ������� ��� ������.
 *
 */
public class Polynom {

	/**
	 * ����, �� ������� ���������
	 * �������������, ������ �� ��� ���� ��� ������ �������� ���� ����� ������� ������
	 */
	private int deg = 0;
	private int[] coefs = null;
	private int[] degs = null;
	
	/**
	 * �����������
	 * @param coefs_ ��'��� ArrayList, ����������� ����������
	 */
	Polynom (ArrayList<Integer> coefs_, ArrayList<Integer> degs_){
		deg = coefs_.size() - 1;
		this.coefs = new int[deg+1];
		this.degs = new int[deg+1];
		for(int i = 0; i < deg + 1; i ++) {
			coefs[i] = coefs_.get(i);
			degs[i] = degs_.get(i);
		}
	}
	
	Polynom (ArrayList<String> coefs_){
		deg = coefs_.size() - 1;
		int[] coefs = new int[deg];
		for(int i = 0; i < deg; i ++) {
			coefs[i] = Integer.parseInt(coefs_.get(i));
		}
	}
	
	/**
	 * �����������
	 * @param coefs_ ����� ����� �����, �����������
	 */
	Polynom(int[] coefs_){
		deg = coefs_.length - 1;
		coefs = coefs_;
	}
	
	Polynom(int[] coefs_, int[] degs_){
		deg = coefs_.length - 1;
		coefs = coefs_;
		degs = degs_;
	}
	
	/**
	 * �����, �� ����������, �� � ��������� �������� �����
	 * @return �� � ��������� �������� �����
	 */
	protected boolean isZero() {
		if(deg == 0 & coefs[0] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * ��������� �����, �� ����������, �� � ��������� �����
	 * @param g ���������
	 * @return �� � ��� ��������� �����
	 */
	protected static boolean isZero(Polynom g) {
		if(g.deg == 0 & g.coefs[0] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * �����, �� ���� 2 ����������
	 * @param f ������ ���������
	 * @param g ������ ���������
	 * @return ���� ����������
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
	
	protected int zeroRoots() {
		int[] sort_coefs = coefs.clone();
		int[] sort_degs = degs.clone();
		for(int pass_num = deg; pass_num>0; pass_num--) {
			for(int i = 0; i < pass_num; i++) {
				if(sort_degs[i] < sort_degs[i+1]) {
					int t = sort_degs[i];
					sort_degs[i] = sort_degs[i+1];
					sort_degs[i+1] = t;
					int c = sort_coefs[i];
					sort_coefs[i] = sort_coefs[i+1];
					sort_coefs[i+1] = c;
				}
			}
		}
		int count = 0, i = 0;
		int current = 0;
		
		while(current==0 && i < deg+1) {
			current = sort_coefs[deg-i];
			i++;
			if(current==0) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * �����, �� ���� 2 ���������� � ������
	 * @param polynoms ����� ����������
	 * @param i ������ ������� ����������
	 * @param j ������ ������� ����������
	 * @return ���� ��� ���� ����������
	 */
	protected static Polynom sumOfTwoPolynoms(Polynom[] polynoms, int i, int j) {
		return Polynom.polySum(polynoms[i-1], polynoms[j-1]);
	}
	
	/**
	 * �����, �� ���� �� ���������� � ������ ����������
	 * @param polynoms ����� ����������
	 * @return ���� ��� ���������� � ������
	 */
	protected static Polynom sumOfAllPolynoms(Polynom[] polynoms) {
		int l = polynoms.length;
		for(int i = 2; i < l + 1; i ++) {
			polynoms[0] = Polynom.sumOfTwoPolynoms(polynoms, 1, i);
		}
		return polynoms[0];
	}
	
	protected void sort_by_deg() {
		for(int pass_num = deg; pass_num>0; pass_num--) {
			for(int i = 0; i < pass_num; i++) {
				if(degs[i] < degs[i+1]) {
					int t = degs[i];
					degs[i] = degs[i+1];
					degs[i+1] = t;
					int c = coefs[i];
					coefs[i] = coefs[i+1];
					coefs[i+1] = c;
				}
			}
		}
	}
	
	/**
	 * �������������� ����� toString()
	 * �������� �� ������� ���������
	 */
	public String toString() {
		
		String s = "";
		
		for (int i = 0; i < deg+1; i++) {
			if (coefs[i] != 0) {
				if (degs[i] == 1) {
					if (coefs[i] > 0) {
						if (coefs[i] != 1) {
							if (!s.equals("")) {
								s += " + " + Integer.toString(coefs[i]) + "x";
							}
							else {
								s += Integer.toString(coefs[i]) + "x";
							}
						}
						else {
							if (!s.equals("")) {
								s += " + x";
							}
							else {
								s += "x";
							}
						}
					}
					else {
						if (coefs[i] != -1) {
							if (!s.equals("")) {
								s += " - " + Integer.toString(-coefs[i]) + "x";
							}
							else {
								s += Integer.toString(coefs[i]) + "x";
							}
						}
						else {
							if (!s.equals("")) {
								s += " - x";
							}
							else {
								s += "x";
							}
						}
					}
				}
				else if (degs[i] == 0) {
					if (coefs[i] > 0) {
						if (!s.equals("")) {
							s += " + " + Integer.toString(coefs[i]);
						}
						else {
							s += Integer.toString(coefs[i]);
						}
					}
					else {
						if (!s.equals("")) {
							s += " - " + Integer.toString(-coefs[i]);
						}
						else {
							s += Integer.toString(coefs[i]);
						}
					}
				}
				else {
					if (coefs[i] > 0) {
						if (coefs[i] != 1) {
							if (!s.equals("")) {
								s += " + " + Integer.toString(coefs[i]) + "x^" + Integer.toString(degs[i]);
							}
							else {
								s += Integer.toString(coefs[i]) + "x^" + Integer.toString(degs[i]);
							}
						}
						else {
							if (!s.equals("")) {
								s += " + x^" + Integer.toString(degs[i]);
							}
							else {
								s += "x^" + Integer.toString(degs[i]);
							}
						}
					}
					else {
						if (coefs[i] != -1) {
							if (!s.equals("")) {
								s += " - " + Integer.toString(-coefs[i]) + "x^"+ Integer.toString(degs[i]);
							}
							else {
								s += Integer.toString(coefs[i]) + "x^" + Integer.toString(degs[i]);
							}
						}
						else {
							if (!s.equals("")) {
								s += " - x^"+ Integer.toString(degs[i]);
							}
							else {
								s +="-x^" + Integer.toString(degs[i]);
							}
						}
					}
				}
			}
		}

		return s;
	}
}
