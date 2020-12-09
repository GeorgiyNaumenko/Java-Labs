package task6;

public class Bus extends Thread {

	private String name = "";
	private String[] route = {""};
	private Route shipping_route = null;
	
	Bus() {
		
	}
	
	Bus(String name_, String[] route_, Route shipping_route_) {
		name = name_;
		route = route_;
		shipping_route = shipping_route_;
	}
	
	@Override
	public void run() {
		this.startShipping();
	}
	
	protected void startShipping() {
		BusStop current = shipping_route.getStart();
		int pos = 0;
		while (!current.equals(shipping_route.getEnd())){
			if (current.getName().equals(route[pos])){
				current.arrive(this);
				current.leave(this);
				pos++;
			}
			current = current.getNext();
		}
	}
	
	protected String getBusName() {
		return name;
	}
}
