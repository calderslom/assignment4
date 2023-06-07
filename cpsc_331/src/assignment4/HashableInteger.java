package assignment4;

public class HashableInteger implements Hashable {

	private Integer value;
	private int p;
	
	public HashableInteger(int n) {
		this.value = new Integer(n);
	}
	
	public Integer key() {
		return this.value;
	}
	
	public boolean Comparable(int x) {
		return x == this.value;
	}
}
