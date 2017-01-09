package xmht.createModel.factory.ordinaryfactory;

/**
 * Created by shengjk1 on 2017/1/6.
 */
/*
静态工厂模式
 */
public class SendFactory {
	public Sender produce(String type){
		if("mail".equalsIgnoreCase(type)){
			return new MailSender();
		}else if ("sms".equalsIgnoreCase(type)){
			return new SmsSender();
		}else {
			System.out.println("请输入正确类型!");
			return null;
		}
	}
}
