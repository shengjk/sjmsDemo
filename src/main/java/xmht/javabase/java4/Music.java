package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/14
 */
enum Note {
	MIDDLE_C, C_SHARP, B_FLAT;
}

class Instrument {
	public void play(Note n) {
		System.out.println("instrument.play");
	}
}

class Wind extends Instrument {
	@Override
	public void play(Note n) {
		System.out.println("Wind.play()" + n);
	}
}

/**
 * 将一个方法调用同一个方法主体关联起来被称作绑定
 * 程序执行前进行绑定的称谓前期绑定(编译的时候为前期绑定)运行时为后期绑定(运行时绑定或者动态绑定)
 * 编译器一直不知道对象类型，但方法调用机制可以找到正确的方法体
 * 多态的时候，Java中出了stati和final方法(private方法属于final方法)之外，其他所有方法都是后期绑定的
 */
public class Music {
	public static void tune(Instrument instrument) {
		instrument.play(Note.MIDDLE_C);
	}
	
	public static void main(String[] args) {
	Wind flute=new Wind();
	tune(flute);
	}
}
