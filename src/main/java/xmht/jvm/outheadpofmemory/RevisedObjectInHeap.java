package xmht.jvm.outheadpofmemory;

import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;

/**
 * Created by shengjk1 on 2017/8/8
 */

//档堆中的对象即将被垃圾回收器释放的时候，会调用该对象的finalize
public class RevisedObjectInHeap{
	private long address=0;
	private Unsafe unsafe=TestUnsafeMemo.getUnsafeInstance();
	
	private byte[] bytes=null;
	
	public RevisedObjectInHeap() throws Exception {
		address=unsafe.allocateMemory(2*1024*1024);
		bytes=new byte[1024*1024];
		TimeUnit.SECONDS.sleep(10);
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize "+bytes.length);
		unsafe.freeMemory(address);
	}
	
	
	public static void main(String[] args) throws Exception {
		while (true){
			RevisedObjectInHeap heap=new RevisedObjectInHeap();
			System.out.println("memory address= "+heap.address);
		}
	}
}
