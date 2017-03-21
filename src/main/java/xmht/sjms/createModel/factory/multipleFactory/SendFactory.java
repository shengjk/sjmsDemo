package xmht.sjms.createModel.factory.multipleFactory;

import xmht.sjms.createModel.factory.ordinaryfactory.MailSender;
import xmht.sjms.createModel.factory.ordinaryfactory.Sender;
import xmht.sjms.createModel.factory.ordinaryfactory.SmsSender;

/**
 * Created by shengjk1 on 2017/1/6.
 */
/*
多个工厂方法模式
 */
public class SendFactory {
	public Sender produceMail(){
		return new MailSender();
	}
	
	
	public Sender produceSms(){
		return new SmsSender();
	}
<<<<<<< HEAD
=======
	
	/**
	 * Created by shengjk1 on 2017/1/6.
	 */
	/*
	多个工厂方法模式
	 */
	public static class SendFactory1 {
		public Sender produceMail(){
			return new MailSender();
		}
		
		
		public Sender produceSms(){
			return new SmsSender();
		}
	}
>>>>>>> origin/master
}
