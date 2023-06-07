package assignment4;

public class HashableInteger implements Hashable {

	private Integer key;
	
	public HashableInteger(int n) {
		this.key = new Integer(n);
	}
	
	public Integer key() {
		return this.key;
	}
	
	public boolean Comparable(int x) {
		return x == this.key;
	}
}
