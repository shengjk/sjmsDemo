package xmht;

import java.util.Random;

class Measurement {
	
	private boolean t;
	char c;
	static byte b;
	protected short s;
	int i;
	long l;
	float f;
	double d;
	void print() {
		System.out.println(
				t+""+c+b+s+i+l+f+d+""
		);
	}
	
}
/**
 * Unit test for simple App.
 */
public class AppTest {
	int i;
	private static int j;
	
	public static void main(String[] args) {
		Random random=new Random(100);
		System.out.println(random.nextInt(3));
	/* In this case you could also say: new Measurement(). pri nt();
	*/
	}
}
