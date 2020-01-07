package xmht.javabase.fanxing;

/**
 * Created by shengjk1 on 2018/4/23
 */
class Customer{
	private static long counter=1;
	private final long id=counter++;
	private Customer(){}
	
	@Override
	public String toString() {
		return "Customer "+id;
	}
}

public class BankTeller {
}
