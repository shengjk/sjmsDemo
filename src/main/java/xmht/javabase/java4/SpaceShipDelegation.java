package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/13
 */

/**
 * 代理模式
 * 可以有更多的控制力
 */
public class SpaceShipDelegation {
	private String name;
	private SpaceShipControls controls=new SpaceShipControls();
	public SpaceShipDelegation(String name){
		this.name=name;
	}
	
	public void back(int velocity){
		controls.back(velocity);
	}
	public void down(int velocity){
		controls.down(velocity);
	}
	public void forward(int velocity){
		controls.forward(velocity);
	}
	public void left(int velocity){
		controls.left(velocity);
	}
	public void right(int velocity){
		controls.right(velocity);
	}
	public void up(int velocity){
		controls.up(velocity);
	}
}
