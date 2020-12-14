package exam;

import java.util.Scanner;

public class biqudratic {

	public static void main(String[] args) throws NegativeDiscrException, ComplexRootsException{
		Scanner input = new Scanner(System.in);
		System.out.println("Введите коэффициенты через пробел:");
		String line = input.nextLine();
		input.close();
		String[] lineCoefs = line.split(" ");
		int a = Integer.parseInt(lineCoefs[0]);
		int b = Integer.parseInt(lineCoefs[1]);
		int c = Integer.parseInt(lineCoefs[2]);
		System.out.println("Биквадратное уравнение: " + a + "x^4 + " + b + "x^2 + " + c);
		double d = b*b - 4*a*c;
		try {
			if (d < 0) {
				throw new NegativeDiscrException(a, b, c);
			}
		}
		catch (NegativeDiscrException e){
			System.out.println(e);
			return;
		}
		double x1 = (-b + Math.sqrt(d)) / (2 * a);
		double x2 = (-b - Math.sqrt(d)) / (2 * a);
		try {
			if(x1 < 0 & x2 < 0) {
				throw new ComplexRootsException();
			}
		}
		catch (ComplexRootsException e) {
			System.out.println(e);
			return;
		}
		System.out.println("Корни:");
		if(x1 > 0) {
			double x1_1 = Math.sqrt(x1), x1_2 = -Math.sqrt(x1);
			System.out.println(x1_1);
			System.out.println(x1_2);
		}
		if(x2 > 0) {
			double x2_1 = Math.sqrt(x2), x2_2 = -Math.sqrt(x2);
			System.out.println(x2_1);
			System.out.println(x2_2);
		}
	}
	
}
