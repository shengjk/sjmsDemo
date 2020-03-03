package xmht.javabase.java4;

/**
 * @author shengjk1
 * @date 2020/3/3
 */
//协变返回类型
public class CovariantReturn {
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain process = m.process();
		System.out.println(process);
		m = new WheatMill();
		process = m.process();
		System.out.println(process);
	}
}

class Grain {
	@Override
	public String toString() {
		return "Grain";
	}
}

class Wheat extends Grain {
	@Override
	public String toString() {
		return "Wheat";
	}
}

class Mill {
	Grain process() {
		return new Grain();
	}
}

//可以返回它的子类
class WheatMill extends Mill {
	@Override
	Wheat process() {
		return new Wheat();
	}
}
