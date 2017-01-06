package xmht.factory.ordinaryfactory;

/**
 * Created by shengjk1 on 2017/1/6.
 */
public class MailSender implements Sender {
	@Override
	public void Send() {
		System.out.println("this is MailSender");
	}
}
