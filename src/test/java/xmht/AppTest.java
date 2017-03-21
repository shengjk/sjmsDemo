package xmht;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static void main(String[] args) {
		int a[]={1,2,3};
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" =============");
		}
		
		
		a[1]=123;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]+" =============");
		}
	}
   
}
