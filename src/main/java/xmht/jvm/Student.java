package xmht.jvm;

/**
 * @author shengjk1
 * @date 2020/9/10
 */
interface People {
	public static void sayHello1() {
	
	}
	
	//invokespecial
	public void sayHello();
}

public class Student implements People {
	//invokestatic   调用静态方法
	public static void test() {
//		System.out.println("我是静态方法");
	}
	
	public static void sayHello1() {
	
	}
	
	public static void main(String[] args) {
		//invokestatic
		test();
		//invokespecial
		Student student = new Student();
		//invokespecial
		student.test1();
		//invokevirtual
		student.hashCode();
		//invokevirtual
		student.equals(student);
		//invokevirtual
		student.sayHello();
		//invokestatic
		Student.sayHello1();
	}
	
	//
	@Override
	public void sayHello() {
	
	}
	
	//invokespecial 调用自己的私有方法，构造方法()以及父类的方法。
	private void test1() {
//		super.sayHello();
	}
}
