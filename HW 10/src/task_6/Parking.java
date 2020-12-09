package task_6;

// Краще було б зробити структуру подібну до хеш-таблиці з лінійним зондуванням,
// але я додумався до цього вже потім...
public class Parking {

	private int size;
	private ParkingNode top;
	
	Parking(){
		
	}
	
	Parking(int N){
		size = N;
		top = new ParkingNode();
		ParkingNode current = top;
		for (int i = 0; i < size - 1; i++) {
			current.setNext(new ParkingNode());
			current = current.getNext();
		}
		current.setNext(top);
	}
	
	protected boolean putCar(int startPos) {
		if(startPos > size) {
			return false;
		}
		ParkingNode current = top;
		for (int i = 0; i < startPos-1; i++) {
			current = current.getNext();
		}
		int n = size;
		while(n > 0) {
			n --;
			if (!current.isEmpty()) {
				current = current.getNext();
			}
			else {
				current.set();
				return true;
			}
		}
		return false;
	}
	
	protected boolean removeCar(int startPos) {
		if(startPos > size) {
			return false;
		}
		ParkingNode current = top;
		for (int i = 0; i < startPos-1; i++) {
			current = current.getNext();
		}
		if (!current.isEmpty()) {
			current.empty();
			return true;
		}
		return false;
	}
}
