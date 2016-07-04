import java.util.ArrayList;


public class FenwickTree {
	private ArrayList<Node> nodes;
	
	public FenwickTree(int size) {
		nodes=new ArrayList<>(size);
	}
	
	public void makeFenwickTree(int[] arr, int start) {
		if(arr.length==1) {
			Node newNode = new Node(start,arr.length);
			newNode.setMax(arr[0]);
			nodes.add(newNode);
			return;
		}
		int len = arr.length;
		int left= start;
		int right = start+len/2;
		Node newNode = new Node(start,arr.length);
		nodes.add(newNode);
		int next = nodes.size();
		makeFenwickTree(slice(arr,left,right-1),left);
		makeFenwickTree(slice(arr,right,right+len/2),right);
		int max = (nodes.get(next).getMax()>nodes.get(next+1).getMax())?
				nodes.get(next).getMax():nodes.get(next+1).getMax();
		newNode.setMax(max);
	}
	
	public int Max(int start, int end) {
		int max = 0;
		return max;
	}
	
	public int[] slice(int[] arr, int start, int end) {
		int[] newArr = new int[end-start+1];
		for(int i=0;i<=end;i++) {
			newArr[i]=arr[start+i];
		}
		return newArr;
	}
}
