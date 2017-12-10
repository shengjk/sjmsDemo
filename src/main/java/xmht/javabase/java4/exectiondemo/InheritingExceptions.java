package xmht.javabase.java4.exectiondemo;

/**
 * Created by shengjk1 on 2017/11/22
 */
class SimpleException extends Exception{
	public SimpleException() {
	}
	
	public SimpleException(String message) {
		super(message);
	}
}

public class InheritingExceptions {
	public void f() throws SimpleException{
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
		InheritingExceptions in=new InheritingExceptions();
		
		try {
			in.f();
		} catch (SimpleException e) {
			e.printStackTrace();
		}
	}
}


class TestException {
	public TestException() {
	}
		
	 boolean testEx2() throws Exception {
		boolean ret = true;
		try {
			int b = 12;
			int c;
			for (int i = 2; i >= -2; i--) {
				c = b / 0;
				System.out.println("i=" + i);
			}
			return true;
		} catch (Exception e) {
			System.out.println("testEx2, catch exception");
			ret = false;
			throw e;
//			return true;
		} finally {
			System.out.println("testEx2, finally; return value=" + ret);
//			return ret;
		}
	}
	
	public static void dd () throws Exception{
		TestException testException1 = new TestException();
		try {
			System.out.println(testException1.testEx2());
		} catch (Exception e) {
			throw (Exception) e;
		}
	}
	
	public static void main(String[] args) {
		try {
			dd();
		} catch (Exception e) {
			e.printStackTrace();
//			e.fillInStackTrace();
		}
	}
}
