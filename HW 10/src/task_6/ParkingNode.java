package task_6;

public class ParkingNode {

	private ParkingNode next = null;
	private boolean empty = true;
	
	ParkingNode(){
		
	}
	
	protected void setNext(ParkingNode nextNode) {
		next = nextNode;
	}
	
	protected ParkingNode getNext() {
		return next;
	}
	
	protected void set() {
		empty = false;
	}
	
	protected void empty() {
		empty = true;
	}
	
	protected boolean isEmpty() {
		return empty;
	}
}
