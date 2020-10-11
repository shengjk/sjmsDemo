/**
 * @author shengjk1
 * @date 2020/9/22
 */
public class FinalExample {
	static FinalExample obj;
	final int j;
	int i;
	
	public FinalExample() {
		this.i = 1;
		this.j = 2;
	}
	
	public static void writer() {
		obj = new FinalExample();
	}
	
	public static void reader() {
		FinalExample object = obj;
		int a = object.i;
		int b = object.j;
		
	}
}
