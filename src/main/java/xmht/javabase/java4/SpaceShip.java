package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/13
 */

public class SpaceShip extends SpaceShipControls {
	private String name;
	public SpaceShip(String name){this.name=name;}
	public String toString(){return name;}
	
	public static void main(String[] args) {
		SpaceShip spaceShip=new SpaceShip("NSEA");
		spaceShip.forward(1000);
	}
}
