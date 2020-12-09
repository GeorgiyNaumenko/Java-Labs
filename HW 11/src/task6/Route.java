package task6;

public class Route {

	private int size = 0;
	private BusStop start = null;
	private BusStop end = null;
	
	Route(){
		
	}
	
	Route(BusStop start_){
		start =  start_;
		size ++;
	}
	
	Route(String[] busStoppes, int[] limits){
		for (int i = 0; i < limits.length; i++) {
			this.addBusStop(busStoppes[i], limits[i]);
		}
	}
	
	protected void addBusStop(String newStopName, int lim) {
		if (size == 0) {
			start = new BusStop(lim, newStopName);
			end = start;
			size++;
		}
		else if(size == 1) {
			BusStop newStop = new BusStop(lim, newStopName);
			newStop.setPrev(start);
			start.setNext(newStop);
			end = newStop;
		}
		else {
			BusStop newStop = new BusStop(lim, newStopName);
			end.setNext(newStop);
			newStop.setPrev(end);
			end = newStop;
		}
	}
	
	protected BusStop getStart() {
		return start;
	}
	
	protected BusStop getEnd() {
		return end;
	}
	
	protected int getSize() {
		return size;
	}
}
