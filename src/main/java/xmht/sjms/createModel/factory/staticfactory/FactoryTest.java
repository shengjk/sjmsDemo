package xmht.sjms.createModel.factory.staticfactory;

import xmht.sjms.createModel.factory.ordinaryfactory.Sender;

/**
 * Created by shengjk1 on 2017/1/6.
 */
public class FactoryTest {
	public static void main(String[] args) {
		Sender sender=SendFactory.produceMail();
		sender.Send();
	}
}
