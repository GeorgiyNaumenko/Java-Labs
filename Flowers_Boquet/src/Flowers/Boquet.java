package Flowers;
import java.util.ArrayList;

public class Boquet {

	private ArrayList <Flower> flowers = new ArrayList<>();
	private int length = 0;
	
	protected void addFlower(Flower newFlower) {
		if (length == 0) {
			flowers.add(newFlower);
		}
		else {
			int left = 0, right = length;
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
	
	
}
