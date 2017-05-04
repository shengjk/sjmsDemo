package xmht.javabase;

class Foo {
	int i = 0;
	public void test(){
		System.out.println("FOO==========");
	}
}

class Bar extends Foo {
	int i = 1;
	public void test(){
		System.out.println("Bar==========");
	}
	
	
	public static void main(String... args) {
		Foo foo = new Bar();
		System.out.println(foo.i);// 属性是谁调用就是谁的
		foo.test();//调用时方法是谁的就是谁的
	}
}