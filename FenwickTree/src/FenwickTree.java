import java.util.ArrayList;


public class FenwickTree {
	private ArrayList<Node> nodes;
	
	public FenwickTree(int size) {
		nodes=new ArrayList<>(size);
	}
	
	public ArrayList<Node> getFenwickTree() {
		return nodes;
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
		int right=start+len-1;
		int mid = (left+right)/2;
		Node newNode = new Node(start,arr.length);
		nodes.add(newNode);
		int next = nodes.size();
		makeFenwickTree(slice(arr,left,mid),left);
		makeFenwickTree(slice(arr,mid+1,right),mid+1);
		int max = (nodes.get(next).getMax()>nodes.get(next+1).getMax())?
				nodes.get(next).getMax():nodes.get(next+1).getMax();
		newNode.setMax(max);
	}
	
	public int Max(int start, int end) {
		int max = 0;
		return max;
	}
	
	public int[] slice(int[] arr, int start, int end) {
		int arrSize = end-start+1;
		int[] newArr = new int[arrSize];
		for(int i=0;i<arrSize;i++) {
			newArr[i]=arr[i];
		}
		return newArr;
	}
}
