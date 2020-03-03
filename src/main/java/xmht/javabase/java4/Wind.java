package xmht.javabase.java4;

/**
 * @author shengjk1
 * @date 2020/3/2
 */
public class Wind extends Instrument {
	@Override
	public void play() {
		System.out.println("子类");
	}
	
	public static void main(String[] args) {
		Wind wind = new Wind();
		Instrument.tune(wind);
		wind.play();
	}
}

class Instrument {
	public void play() {
		System.out.println("父类");
	}
	
	
	static void tune(Instrument i) {
		System.out.println("父类");
	}
	
}