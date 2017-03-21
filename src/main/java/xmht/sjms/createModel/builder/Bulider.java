package xmht.sjms.createModel.builder;

import xmht.sjms.createModel.factory.abstactfactory.MailSender;
import xmht.sjms.createModel.factory.abstactfactory.Sender;
import xmht.sjms.createModel.factory.abstactfactory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjk1 on 2017/1/9.
 */
public class Bulider {
	private List<Sender> list=new ArrayList<Sender>();
	
	public void productMailSender(int count){
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}
	
	public void produceSmsSender(int count){
		for (int i = 0; i <count ; i++) {
			list.add(new SmsSender());
		}
	}
}
