package xmht.javabase.java4.classdemo;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by shengjk1 on 2017/11/21
 */

public class HasF{
	public void f(){
		System.out.println("HasF.f()");
	}
}
class Manipulator<T extends HasF>{
	private T obj;
	public Manipulator(T x){obj=x;}
	public void manipulate(){obj.f();};
}

class Man{
	public static void main(String[] args) {
		HasF hf =new HasF();
		Manipulator<HasF> manipulator=new Manipulator<>(hf);
		manipulator.manipulate();
	}
}


class Foo<T> extends Man{
	T var;
	
	public static void main(String[] args) {
		Foo<Man> foo=new Foo<>();
		System.out.println(foo.getClass());
		System.out.println(foo.getClass().getName());
		System.out.println(foo.getClass().getName());
		System.out.println(foo.getClass().getAnnotatedSuperclass().getType().getTypeName());
		AnnotatedType annotatedSuperclass = foo.getClass().getAnnotatedSuperclass();
		System.out.println(annotatedSuperclass.getClass().getAnnotatedSuperclass().getType());
		System.out.println();
	}
}

class ArrayMaker<T>{
	private Class<T> kind;
	
	public ArrayMaker(Class<T> kind) {
		this.kind = kind;
	}
	T[] create(int size){
		return (T[])Array.newInstance(kind,size);
	}
	
	public static void main(String[] args) {
		ArrayMaker<String> stringArrayMaker=new ArrayMaker<>(String.class);
		String[] string=stringArrayMaker.create(9);
		System.out.println(Arrays.toString(string));
	}
}