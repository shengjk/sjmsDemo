package xmht.concurrency.thread.demo4;

/**
 * @author shengjk1
 * @date 2019/8/26
 */
public class FinalExample {
	int i;
	final int j;
	static FinalExample obj;
	
	public FinalExample() {
		this.i = 1;
		this.j = 2;
	}
	
	public static void writer(){
		obj=new FinalExample();
	}
	public static void reader(){
		FinalExample object=obj;
		int a= object.i;
		int b=object.j;
	}
}
