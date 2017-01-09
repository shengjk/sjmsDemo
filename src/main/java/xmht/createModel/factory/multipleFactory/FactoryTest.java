package xmht.createModel.factory.multipleFactory;

import xmht.createModel.factory.ordinaryfactory.Sender;

/**
 * Created by shengjk1 on 2017/1/6.
 */
public class FactoryTest {
	public static void main(String[] args) {
		SendFactory factory=new SendFactory();
		Sender sender=factory.produceMail();
		sender.Send();
	}
}
