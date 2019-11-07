package xmht.javabase.effictjava.chapter02.test03;

/**
 * @author shengjk1
 * @date 2019-05-14
 */
public enum Elvis {
	INSTANCE;
	
	public void leaveTheBuilding(){}
	
	// This code would normally appear outside the class!
	public static void main(String[] args) {
		Elvis elvis = Elvis.INSTANCE;
		elvis.leaveTheBuilding();
	}
}
