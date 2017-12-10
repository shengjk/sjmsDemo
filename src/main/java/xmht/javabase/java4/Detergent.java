package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/13
 */
class Cleanser{
	private String s ="Cleanser";
	public void append(String a){
		s+=a;
	}
	public void dilute(){
		append("dilute()");
	}
	
	public void apply(){
		append("apply()");
	}
	public String toString(){
		System.out.println(s);
		return s;
	}
	
	public static void main(String[] args) {
		Cleanser cleanser=new Cleanser();
		cleanser.apply();
	}
}
public class Detergent extends Cleanser{
	public void apply(){
		append("detergent.apply()");
		super.apply();
		
	}
	
	public static void main(String[] args) {
		Detergent detergent=new Detergent();
		detergent.apply();
		detergent.toString();
	}
}
