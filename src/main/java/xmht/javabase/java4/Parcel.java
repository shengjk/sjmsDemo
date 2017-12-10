package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/14
 */
public class Parcel {
	class Contents{
		private int i=11;
		public int value(){
			return i;
		}
	}
	class Destination{
		private String label;
		Destination(String whereTo){
			label=whereTo;
		}
		String readLabel(){return label;}
	}
	
	public void ship(String dest){
		Contents contents=new Contents();
		Destination destination=new Destination(dest);
		System.out.println(destination.readLabel());
	}
	
	public static void main(String[] args) {
		Parcel p=new Parcel();
		p.ship("Tasmania");
	}
}
