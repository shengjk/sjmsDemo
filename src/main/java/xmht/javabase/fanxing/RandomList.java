package xmht.javabase.fanxing;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by shengjk1 on 2018/4/23
 */
public class RandomList<T> {
	private final ArrayList<T> storage = new ArrayList<T>();
	private final Random random = new Random(47);
	
	public void add(T item) {
		storage.add(item);
	}
	
	public T select() {
		return storage.get(random.nextInt(storage.size()));
	}
	
}
