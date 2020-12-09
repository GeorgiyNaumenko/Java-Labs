package task6;

public class BusStop {

	private BusStop next = null;
	private BusStop prev = null;
	private int limit = 10;
	private int currentBusses = 0;
	private String name = "";
	
	BusStop() {
		
	}
	
	BusStop(BusStop next_, BusStop prev_, int lim, String name_){
		next = next_;
		prev = prev_;
		limit = lim;
		name = name_;
	}
	
	BusStop(int lim, String name_){
		limit = lim;
		name = name_;
	}
	
	BusStop(BusStop next_, BusStop prev_, String name_){
		next = next_;
		prev = prev_;
		name = name_;
	}
	
	protected void setName(String name_) {
		name = name_;
	}
	
	protected String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "bus stop " + name;
	}
	
	protected void setLimit(int newLimit) {
		limit = newLimit;
	}
	
	protected int getLimit() {
		return limit;
	}
	
	protected void setNext(BusStop next_) {
		next = next_;
	}
	
	protected BusStop getNext() {
		return next;
	}
	
	protected void setPrev(BusStop prev_) {
		prev = prev_;
	}
	
	protected BusStop getPrev() {
		return prev;
	}
	
	protected boolean arrive(Bus bus) {
		if(currentBusses-1 < limit) {
			currentBusses ++;
			System.out.println(bus.toString() + " arrived to bus station "+ name);
			return true;
		}
		System.out.println(bus.toString() + " didn't arrive to bus station "+ name + " - station is full");
		return false;
	}
	
	protected boolean leave(Bus bus) {
		if(currentBusses > 0) {
			currentBusses --;
			System.out.println(bus.toString() + " left bus station "+ name);
			return true;
		}
		return false;
	}
	
	public boolean equals(BusStop busStop) {
		return this.name.equals(busStop.name);
	}
}
