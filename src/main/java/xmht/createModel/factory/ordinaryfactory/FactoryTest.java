package xmht.createModel.factory.ordinaryfactory;

/**
 * Created by shengjk1 on 2017/1/6.
 */
public class FactoryTest {
	public static void main(String[] args) {
		SendFactory factory=new SendFactory();
		Sender sender=factory.produce("sms");
		sender.Send();
	}
}
