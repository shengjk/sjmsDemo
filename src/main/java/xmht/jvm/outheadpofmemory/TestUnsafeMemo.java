package xmht.jvm.outheadpofmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by shengjk1 on 2017/8/8
 * 不会自动回收
 */
public class TestUnsafeMemo {
	
	public static Unsafe getUnsafeInstance() throws Exception
	{
		// 通过反射获取rt.jar下的Unsafe类
		Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafeInstance.setAccessible(true);
		// return (Unsafe) theUnsafeInstance.get(null);是等价的
		return (Unsafe) theUnsafeInstance.get(Unsafe.class);
	}
	
	public static void main(String[] args) throws Exception {
		Unsafe unsafe = getUnsafeInstance();
		
		while (true){
			long point=unsafe.allocateMemory(20*1024*1024);
			System.out.println(unsafe.getByte(point+1));
			
//			unsafe.freeMemory(point);
		}
	}
}
