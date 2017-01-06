package xmht.bridge;

/**
 * Created by shengjk1 on 2016/11/7.
 */
public class BridgeTest {
	
	public static void main(String[] args) {
		Bridge bridge=new MyBridge();
		
		//第一个对象
		Sourceable sourceable1=new SourceSub1();
		bridge.setSourceable(sourceable1);
		bridge.method();
		
		//第二个对象
		Sourceable sourceable2=new SourceSub2();
		bridge.setSourceable(sourceable2);
		bridge.method();
	}
}
