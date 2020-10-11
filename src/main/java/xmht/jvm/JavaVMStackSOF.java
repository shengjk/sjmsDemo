package xmht.jvm;

/**
 * @author shengjk1
 * @date 2020/9/12
 */
/*
-Xss160k
 */
public class JavaVMStackSOF {
	private int stackLenght = 1;
	
	public static void main(String[] args) {
		JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
		try {
			javaVMStackSOF.stackLeak();
		} catch (Exception e) {
		
		} catch (Throwable e) {
			System.out.println("stacXk length:" + javaVMStackSOF.stackLenght);
		}
	}
	
	public void stackLeak() {
		stackLenght++;
		stackLeak();
	}
}
