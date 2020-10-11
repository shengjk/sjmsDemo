/**
 * @author shengjk1
 * @date 2020/9/23
 */
public class FinalReferenceExample {
	static FinalReferenceExample obj;
	final int[] intArray;
	
	public FinalReferenceExample() {
		intArray = new int[1];
		intArray[0] = 1;
	}
	
	public static void writerOne() {
		obj = new FinalReferenceExample();
	}
	
	public static void writeTwo() {
		obj.intArray[0] = 2;
	}
	
	public static void reader() {
		if (obj != null) {
			int temp1 = obj.intArray[0];
		}
	}
	
	public static void main(String[] args) {
		FinalReferenceExample.writeTwo();
	}
}
