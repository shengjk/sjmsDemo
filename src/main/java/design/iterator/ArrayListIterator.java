package design.iterator;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
public class ArrayListIterator implements Iterator {
	ArrayList<MenuItem> items;
	int postion = 0;
	
	public ArrayListIterator(ArrayList<MenuItem> items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		return !(postion >= items.size());
	}
	
	@Override
	public MenuItem next() {
		return items.get(postion++);
	}
}
