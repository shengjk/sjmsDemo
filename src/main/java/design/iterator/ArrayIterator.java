package design.iterator;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
public class ArrayIterator implements Iterator {
	MenuItem[] items;
	int postion = 0;
	
	public ArrayIterator(MenuItem[] items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		return !(postion >= items.length || items[postion] == null);
	}
	
	@Override
	public MenuItem next() {
		return items[postion++];
	}
}
