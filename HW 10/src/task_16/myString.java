package task_16;

public class myString {

	private String str = "";
	
	myString(String str_){
		str = str_;
	}
	
	myString(){
		
	}
	
	public void set(String str_) {
		str = str_;
	}
	
	public int length() {
		return str.length();
	}
	
	@Override
	public String toString() {
		return str;
	}
	
	@Override
	public int hashCode() {
		int hashcode = 0, n = str.length();
		int current;
		for (int i = 0; i < n; i++) {
			current = (int) str.charAt(i);
			if (current >= 65 && current <= 90) {
				current += 32;
			}
			hashcode += current * (Math.pow(15, n-i-1));
		}
		return hashcode;
	}
	
	@Override
	public boolean equals(Object o){
		return (o.hashCode() == this.hashCode());
	}
}
