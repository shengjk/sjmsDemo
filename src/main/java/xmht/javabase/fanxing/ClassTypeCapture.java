package xmht.javabase.fanxing;

/**
 * Created by shengjk1 on 2018/4/23
 */

//解决类型擦除
/*
class Erased<T>{
	private  final int SIZE=100;
	public  void f(Object arg){
		if (arg instanceof T){}  //ERROE
		T var =new T();//ERROE
		T[] array=new T[SIZE];//ERROE
		T[] array1=(T[])new Object[SIZE];//Unchecked warning
	}
}
new T()的尝试无法实现，部分原因是因为擦除，另一部分原因是因为编译器不能验证T具有默认构造器
 */

class Building{}
class House extends Building{}

//不赞成使用这种方式,建议使用显示的工厂，并限制类型
class ClassAsFactory<T>{
	T x;
	public ClassAsFactory(Class<T> kind){
		try {
			x=kind.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}


public class ClassTypeCapture<T> {
	Class<T> kind;
	
	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
	}
	
	public boolean f(Object arg){
		return kind.isInstance(arg) ;
	}
	
	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
		
		ClassAsFactory<House> houseClassAsFactory = new ClassAsFactory<>(House.class);
		//INteger会创建失败，因为它没有任何默认构造器
		ClassAsFactory<Integer> IntegerClassAsFactory = new ClassAsFactory<>(Integer.class);
		
	}
}
