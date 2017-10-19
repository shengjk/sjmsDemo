package xmht.sjms.structureModel.adapter;

import xmht.sjms.structureModel.adapter.objadapter.SourceSub1;
import xmht.sjms.structureModel.adapter.objadapter.Sourceable;
import xmht.sjms.structureModel.adapter.objadapter.Wrapper2;

/**
 * Created by shengjk1 on 2016/11/7.
 */
public class SourceSub2 extends Wrapper2 {
	@Override
	public void method2() {
		System.out.println("the sourceable interface's second Sub2!");
	}
}

class WrapperTest{
	public static void main(String[] args) {
		Sourceable sourceable1=new SourceSub1();
		Sourceable sourceable2=new SourceSub2();
		
//		sourceable1.method1();
		sourceable1.method2();
		sourceable2.method1();
//		sourceable2.method2();
		
		
	}
}