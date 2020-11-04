package Flowers;
import java.util.ArrayList;

public class Boquet {

	private ArrayList <Flower> flowers = new ArrayList<>();
	
	Boquet(){
		
	}
	
	Boquet(ArrayList <Flower> _flowers){
		flowers = _flowers;
	}
	
	protected int getLength() {
		return flowers.size();
	}
	
	protected void addFlower(Flower newFlower) {
		if (getLength() == 0) {
			flowers.add(newFlower);
		}
		else {
			int left = 0, right = getLength();
			while(left < right) {
				int m = left + (right - left) / 2;
				if (newFlower.length() >= flowers.get(m).length()) {
					left = m + 1;
				}
				else {
					right = m;
				}
			}
			flowers.add(left, newFlower);
		}
	}
	
	protected boolean removeFlower(Flower flower) {
		return flowers.remove(flower);
	}
	
	protected ArrayList <Flower> getForRange(float a, float b){
		ArrayList <Flower> res = new ArrayList<>();
		
		return res;
	}
	
}
