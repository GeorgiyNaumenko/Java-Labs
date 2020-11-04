package Moto;

public class Equipment {

	private String name, manufacturer;
	private double price, weight;
	
	Equipment() {
		
	}
	
	Equipment(String _manufacturer, String _name, double _price, double _weight){
		manufacturer = _manufacturer;
		name = _name;
		price = _price;
		weight = _weight;
	}
	
	protected void setPrice(double newPrice){
		price = newPrice;
	}
	
	protected void setWeight(double newWeight) {
		weight = newWeight;
	}
	
	@Override
	public String toString() {
		return name + " by " + manufacturer + ", price: " + price + ", weight: " + weight;
	}
	
	protected String getName() {
		return name;
	}
	
	protected String getManufacturer() {
		return manufacturer;
	}
	
	protected double getPrice() {
		return price;
	}

	protected double getWeight() {
		return weight;
	}
}
