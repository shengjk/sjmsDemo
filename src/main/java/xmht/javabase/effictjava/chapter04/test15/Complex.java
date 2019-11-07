package xmht.javabase.effictjava.chapter04.test15;

/**
 * @author shengjk1
 * @date 2019-06-26
 */
public class Complex {
	private final double re;
	private final double im;
	
	private Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	public static Complex valueOf(double re,double im){
		return new Complex(re,im);
	}
}
