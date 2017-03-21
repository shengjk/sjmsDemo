package xmht.sjms.createModel.factory.staticfactory;

import xmht.sjms.createModel.factory.ordinaryfactory.MailSender;
import xmht.sjms.createModel.factory.ordinaryfactory.Sender;
import xmht.sjms.createModel.factory.ordinaryfactory.SmsSender;

/**
 * Created by shengjk1 on 2017/1/6.
 */
/*
多个工厂方法模式
说的再通俗一点就是，单独的一个类专门用来创建对象，这个类就叫做工厂
 */
public class SendFactory {
	public static  Sender produceMail(){
		return new MailSender();
	}
	
	
	public static  Sender produceSms(){
		return new SmsSender();
	}
}
