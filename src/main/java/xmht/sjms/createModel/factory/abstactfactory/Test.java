package xmht.sjms.createModel.factory.abstactfactory;

/**
 * Created by shengjk1 on 2017/1/6.
 */
public class Test {
	public static void main(String[] args) {
		Provider provider=new SendMailFactory();
		Sender sender=provider.produce();
		sender.Send();
	}
}
