package xmht.arts.week2;

import java.util.ArrayList;
import java.util.List;

public interface Animal {
	List<Animal> getAnimals();
}

class Dog implements Animal {
	@Override
	//对于泛型来说，不能返回 泛型参数的子类，但可以返回泛型类的子类
	public ArrayList<Animal> getAnimals() {
		return null;
	}
	
}