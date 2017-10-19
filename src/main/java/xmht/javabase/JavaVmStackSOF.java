package xmht.javabase;

/**
 * Created by shengjk1 on 2016/9/6.
 */
public class JavaVmStackSOF {
	private int statckLeak=1;
	
	public void stackLeak(){
		statckLeak ++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVmStackSOF oom =new JavaVmStackSOF();
		
		try {
			oom.stackLeak();
		}catch (Throwable e){
			System.out.println("=============== "+oom.statckLeak);
			throw  e;
		}
	}
}
