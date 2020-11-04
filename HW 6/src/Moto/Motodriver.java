package Moto;
import java.util.ArrayList;

public class Motodriver {

	private ArrayList <Equipment> equip = new ArrayList<>();
	private String moto, name;
	private int age, maxSpeed, experience;
	
	Motodriver() {
		
	}
	
	Motodriver(String _name, String _moto, int _age, int _maxSpeed, int _exp) {
		name = _name;
		moto = _moto;
		age = _age;
		maxSpeed = _maxSpeed;
		experience = _exp;
	}
	
	Motodriver(String _name, String _moto, int _age, int _maxSpeed) {
		name = _name;
		moto = _moto;
		age = _age;
		maxSpeed = _maxSpeed;
		experience = 0;
	}
	
	protected void setMoto(String newMoto) {
		moto = newMoto;
	}
	
	protected void expUp() {
		experience ++;
	}
	
	protected String getName() {
		return name;
	}
	
	protected String getMoto() {
		return moto;
	}
	
	protected int getExp() {
		return experience;
	}
	
	protected int getAge() {
		return age;
	}
	
	protected int getMaxSpeed() {
		return maxSpeed;
	}
	
	protected ArrayList <Equipment> getEquipment(){
		return equip;
	}
	
	@Override
	public String toString() {
		String s = name + ", " + age + " years, " + moto + System.lineSeparator() + "Equipment:";
		s += System.lineSeparator();
		int k = equip.size();
		for(int i = 0; i < k; i ++) {
			s += equip.get(i) + System.lineSeparator();
		}
		return s;
	}
	
	protected void addNew(Equipment toAdd) {
		int length = equip.size();
		if (length == 0) {
			equip.add(toAdd);
		}
		else {
			int left = 0, right = length;
			while(left < right) {
				int m = left + (right - left) / 2;
				if (toAdd.getPrice() >= equip.get(m).getPrice()) {
					left = m + 1;
				}
				else {
					right = m;
				}
			}
			equip.add(left, toAdd);
		}
	}
	
	protected boolean removeEquip(Equipment eq) {
		return equip.remove(eq);
	}

	protected Equipment removeEquip(int i) {
		return equip.remove(i);
	}
	
	protected void sortByWeight() {
		int n = equip.size();
		for(int pass_num = n-1; pass_num>0; pass_num--) {
			for(int i = 0; i < pass_num; i++) {
				if(equip.get(i).getWeight() < equip.get(i+1).getWeight()) {
					Equipment t = equip.remove(i+1);
					equip.add(i, t);
				}
			}
		}
	}
}
