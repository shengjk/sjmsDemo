package xmht.sjms.createModel.factory.abstactfactory;

/**
 * Created by shengjk1 on 2017/1/6.
 */
public class SendMailFactory implements Provider {
	@Override
	public Sender produce() {
		return new MailSender();
	}
}
