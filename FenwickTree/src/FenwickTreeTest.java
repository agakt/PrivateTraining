
public class FenwickTreeTest {

	public static void main(String[] argv) {
		int arr[]={1,2,3,4,5,6,7,8,9,10};
		
		FenwickTree fenwick = new FenwickTree(10);
		
		fenwick.makeFenwickTree(arr,0);
		
		System.out.println(fenwick.Max(3, 6));
	}
}
