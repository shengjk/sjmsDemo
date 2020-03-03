package xmht.javabase.java4;

/**
 * @author shengjk1
 * @date 2020/3/2
 */
public class FieldAccess {
	public static void main(String[] args) {
		Sub sub = new Sub();
	}
}

class Super {
	public int field = 0;
	
	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;
	
	@Override
	public int getField() {
		return field;
	}
	
	public int getSuperField() {
		return super.field;
	}
}