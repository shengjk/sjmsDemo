package xmht.javabase.java4;

import java.util.Arrays;

/**
 * Created by shengjk1 on 2017/11/13
 */


class Window{
	Window(int marker){
		System.out.println("Window "+marker);
	}
}

class House{
	
	static Window w0=new Window(0);
	Window w1 =new Window(1);
	House(){
		System.out.println("House ");
		w3=new Window(33);
	}
	
	Window w2=new Window(2);
	void f(){
		System.out.println("f()");
	}
	Window w3 =new Window(3);
	static Window w10=new Window(10);
}


class Bowl{
	Bowl(int market){
		System.out.println("Bowl" +market);
	}
	void f1(int market){
		System.out.println("f1 "+market);
	}
}




class Table{
	static Bowl bowl1=new Bowl(1);
	Table(){
		System.out.println("table()");
		bowl2.f1(1);
	}
	void f2(int market){
		System.out.println("f2 "+market);
	}
	static Bowl bowl2=new Bowl(2);
}
class Cupboard{
	Bowl bowl3=new Bowl(3);
	static Bowl bowl4=new Bowl(4);
	Cupboard(){
		System.out.println("CupBoard");
		bowl4.f1(2);
	}
	void f3(int market){
		System.out.println("f3 "+market);
	}
	static Bowl bowl5=new Bowl(5);
}

class Cup{
	Cup(int market){
		System.out.println("cup "+market);
	}
	void f(int market){
		System.out.println("f "+market);
	}
}

class Cups{
	static Cup cup1;
	static Cup cup2;
	static {
		cup1=new Cup(1);
		cup2=new Cup(2);
	}
	Cups(){
		System.out.println("Cups()");
	}
	
}

class Mug{
	Mug(int market){
		System.out.println("Mug "+market);
	}
	void  f(int market){
		System.out.println("f "+market);
	}
}

public class InIt {
	public static void main(String[] args) {
//		House h =new House();
//		House h1 =new House();
//		h.f();
//		System.out.println("create new cupboard in main");
//		new Cupboard();
//		System.out.println("create new cupboard in main");
//		new Cupboard();
//		table.f2(1);
//		cupboard.f3(1);
		
//		System.out.println("Inside main");
//		Cups.cup1.f(99);
	
//		int[] a1={1,2,3,4,5};
		Integer[] a1=new Integer[20];
		int[] a2=new int[2];
//		a2=a1;
		for (int i = 0; i < a2.length; i++) {
			a2[i]=a2[i]+1;
		}
		
		for (int i = 0; i < a1.length; i++) {
			System.out.println(a1[i]);
		}
		
		System.out.println(Arrays.toString(a1));
//		char[] c1=new char[20];
//		for (int i = 0; i < c1.length; i++) {
//			System.out.println(c1[i]);
//		}
	}
//	static Cups cups1=new Cups();
//	static Cups cups2=new Cups();
//	static Table table=new Table();
//	static Cupboard cupboard=new Cupboard();
}

class AutoBox{
	public static void f(Integer... args){
		System.out.println(args.getClass());
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
	
	public static void main(String[] args) {
		f(4,5,6,7,8);
	}
}