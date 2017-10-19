package xmht.sjms.structureModel.adapter.classadapter;

/**
 * Created by shengjk1 on 2016/11/7.
 */
public class AdapterTest {
	public static void main(String[] args) {
		Targetable targetable=new Adapter();
		targetable.method1();
		targetable.method2();
	}
}
