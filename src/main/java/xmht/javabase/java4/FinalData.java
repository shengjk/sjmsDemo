package xmht.javabase.java4;

import java.util.Random;

/**
 * @author shengjk1
 * @date 2020/3/2
 */
public class FinalData {
	private static Random random = new Random(47);
	private String id;
	
	public FinalData(String id) {
		this.id = id;
	}
	
	private final int valueOne = 9;
	private static final int VALUE_TWO = 99;
	public static final int VALUE_THREE = 39;
	private final int i4 = random.nextInt(20);
	private final int iNT_5 = random.nextInt(20);
	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	private final int[] a = {1, 2, 3, 4, 5, 6};
	
	public static void main(String[] args) {
		FinalData fd1 = new FinalData("fd1");
		
	}
}

class Value {
	int i;
	
	public Value(int i) {
		this.i = i;
	}
}