package Flowers;

public class Flower {

	private String color, name;
	private int leaves;
	private double length;
	
	Flower() {
		
	}
	
	Flower(String _color, String _name, int _leaves, double _length) {
		color = _color;
		name = _name;
		leaves = _leaves;
		length = _length;
	}
	
	@Override
	public String toString() {
		return name + ", " + color + ", довжина: " + length + ", кількість листків: " + leaves;
	}
	
	protected double length() {
		return length;
	}
	
	protected String getName() {
		return name;
	}
	
	protected String getColor() {
		return color;
	}
	
	protected int getLeaves() {
		return leaves;
	}
	
	protected void setLength(double newLength) {
		length = newLength;
	}
	
	protected void setName(String newName) {
		name = newName;
	}
	
	protected void setColor(String newColor) {
		color = newColor;
	}
	
	protected void setLeaves(int newLeaves) {
		leaves = newLeaves;
	}
	
}
