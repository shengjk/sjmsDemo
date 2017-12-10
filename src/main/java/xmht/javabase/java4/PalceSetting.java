package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/13
 */

/**
 * 组合继承同时使用
 */
class Plate{
	Plate(int i){
		System.out.println("Plate constructor");
	}
}

class DinnerPlate extends Plate{
	DinnerPlate(int i){
		super(i);
		System.out.println();
	}
}

class Utensil{
	Utensil(int i){
		System.out.println("Utensil constructor");
	}
}

class Spoon extends Utensil{
	Spoon(int i){
		super(i);
		System.out.println("Spoon constructor");
	}
}

class Knife extends Utensil{
	Knife(int i){
		super(i);
		System.out.println("knife constructor");
	}
}

class Custom{
	Custom(int i){
		System.out.println("Custom constructor");
	}
}
public class PalceSetting extends Custom{
	private Spoon spoon;
	private Knife knife;
	private DinnerPlate dinnerPlate;
	
	public PalceSetting(int i){
		super(i+1);
		spoon=new Spoon(i+2);
		knife=new Knife(i+2);
	}
	
	public static void main(String[] args) {
		PalceSetting palceSetting=new PalceSetting(9);
	}
}
