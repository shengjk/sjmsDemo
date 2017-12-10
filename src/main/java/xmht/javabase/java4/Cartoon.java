package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/13
 */

class Art {
	Art() {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art{
//	Drawing(){
//		System.out.println("Drawing constructor");
//	}
	Drawing(int i){
		System.out.println("Drawing constructor");
	}
}

public class Cartoon extends Drawing{
	public Cartoon(){
		super(1);
		System.out.println("Cartoon constructor");
	}
	
	public static void main(String[] args) {
		Cartoon x =new Cartoon();
	}
}
