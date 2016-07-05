
public class FenwickTreeTest {

	public static void main(String[] argv) {
		int arr[]={1,2,3,4};
		
		FenwickTree fenwick = new FenwickTree(10);
		
		fenwick.makeFenwickTree(arr,0);
		
		for(int index=0;index<fenwick.getFenwickTree().size();index++) {
			System.out.println(fenwick.getFenwickTree().get(index).getSize());
		}
		
		//System.out.println(fenwick.Max(3, 6));
	}
}
