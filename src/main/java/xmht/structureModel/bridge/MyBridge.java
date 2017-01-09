package xmht.structureModel.bridge;

/**
 * Created by shengjk1 on 2016/11/7.
 */
public class MyBridge extends Bridge {
	public void method() {
		getSourceable().method();
	}
}
