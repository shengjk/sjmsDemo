package xmht.factory.multipleFactory;

import xmht.factory.ordinaryfactory.MailSender;
import xmht.factory.ordinaryfactory.Sender;
import xmht.factory.ordinaryfactory.SmsSender;

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
}
