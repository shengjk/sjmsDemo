package xmht.jvm;

/**
 * Created by shengjk1 on 2017/8/30.
 */
public class Test {
	public static void main(String[] args) {
		{
			byte[] placeholder=new byte[64*1024*1024];
			placeholder=null;
		}
//		int a=0;z
		System.gc();
	}
}
