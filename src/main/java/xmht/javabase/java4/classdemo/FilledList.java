package xmht.javabase.java4.classdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shengjk1 on 2017/11/21
 */
class Building{}
class House extends Building{}

class CountedInteger{
	private static long counter;
	private final long id=counter++;
	public String toString(){return Long.toString(id);}
}

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){this.type=type;}
	public List<T> create(int nElements){
		List<T> result=new ArrayList<>();
		try {
			for (int i = 0; i < nElements; i++) {
				result.add(type.newInstance());
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void main(String[] args) {
		FilledList<CountedInteger> fl=new FilledList<>(CountedInteger.class);
		System.out.println(fl.create(15));
		
		Building building=new House();
		Class<House> houseType=House.class;
		House h=houseType.cast(building);
		h=(House)building;
		System.out.println(building instanceof Building);
		System.out.println(building instanceof House);
		
		
		
	}
	public static final List<Class<? extends Building>> allTypes= Collections.unmodifiableList(
			Arrays.asList(Building.class,House.class)
	);
}
