package xmht.jvm.outheadpofmemory;

import java.util.concurrent.TimeUnit;

/**
 * Created by shengjk1 on 2017/8/11
 */
/*
 *-verbose:gc
-Xms20M
-Xmx20M
-Xmn10M
-XX:+PrintGCDetails
-XX:SurvivorRatio=8
 */


public class TestAllocation {
	private static final  int _1MB=1024*1024;
	
	public static void  testAlloction(){
		byte[] alloction1,allocation2,allcation3,allcation4;
		alloction1=new byte[2* _1MB];
		allocation2=new byte[2* _1MB];
		allcation3=new byte[2* _1MB];
		allcation3=new byte[2* _1MB];
		allcation4=new byte[4* _1MB];
		
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("=================");
		
	}
	
	
	public static void testTenuringThreshold(){
		byte[] alloction1,allocation2,allcation3,allcation4;
		alloction1=new byte[_1MB/4];
		allocation2=new byte[4* _1MB];
		allcation3=new byte[4* _1MB];
		allcation3=null;
		allcation3=new byte[4* _1MB];
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=================");
		
	}
	
	public static void main(String[] args) {
		testAlloction();
	}
	
	
	
	
}
