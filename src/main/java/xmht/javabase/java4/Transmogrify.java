package xmht.javabase.java4;

/**
 * @author shengjk1
 * @date 2020/3/3
 */
public class Transmogrify {
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.preformPlay();
		//运行期间获得了状态的灵活性
		stage.chage();
		stage.preformPlay();
	}
}

class Actor {
	public void act() {
	}
}

class HappyActor extends Actor {
	@Override
	public void act() {
		System.out.println("HappyActor");
	}
}

class SadActor extends Actor {
	@Override
	public void act() {
		System.out.println("SadActor");
	}
}

class Stage {
	private Actor actor = new HappyActor();
	
	public void chage() {
		actor = new SadActor();
	}
	
	public void preformPlay() {
		actor.act();
	}
}