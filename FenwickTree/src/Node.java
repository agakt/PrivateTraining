
public class Node {
	private int max;
	
	private final int start;
	
	private final int size;
	
	public Node(int start, int size) {
		this.max=0;
		this.start=start;
		this.size=size;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max=max;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getStart() {
		return start;
	}
}
