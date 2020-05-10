package xmht.javabase.classinfofanshe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjk1 on 2018/4/13
 */
class CountedInteger {
	private static long counter;
	private final long id = counter++;
	
	@Override
	public String toString() {
		return Long.toString(id);
	}
}

public class FiledList<T> {
	private final Class<T> type;
	
	public FiledList(Class<T> type) {
		this.type = type;
	}
	
	public static void main(String[] args) {
		FiledList<CountedInteger> countedIntegerFiledList = new FiledList<>(CountedInteger.class);
		System.out.println(countedIntegerFiledList.create(15));
	}
	
	public List<T> create(int nElements) {
		List<T> result = new ArrayList<>();
		for (int i = 0; i < nElements; i++) {
			try {
				result.add(type.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
