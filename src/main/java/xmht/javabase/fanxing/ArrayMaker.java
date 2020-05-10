package xmht.javabase.fanxing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shengjk1 on 2018/4/23
 */
public class ArrayMaker<T> {
	private final Class<T> kind;
	
	public ArrayMaker(Class<T> kind) {
		this.kind = kind;
	}
	
	public static void main(String[] args) {
		ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
		String[] strings = stringMaker.create(9);
		System.out.println(Arrays.toString(strings));
	}
	
	T[] create(int size) {
		return (T[]) Array.newInstance(kind, size);
	}
}

class ListMaker<T> {
	public static void main(String[] args) {
		ListMaker<String> listMaker = new ListMaker<String>();
		List<String> strings = listMaker.create();
	}
	
	List<T> create() {
		return new ArrayList<>();
	}
}

