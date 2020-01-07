package xmht.concurrency.thread.demo4;

/**
 * @author shengjk1
 * @date 2019/8/26
 */
public class VolatileExample {
	int a=0;
	volatile boolean flag=false;
	public void writer(){
		a=1;
		flag=true;
	}
	public void reader(){
		if (flag){
			int i=a;
		}
	}
}
