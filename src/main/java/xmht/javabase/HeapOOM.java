package xmht.javabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjk1 on 2016/9/6.
 */
public class HeapOOM {
	static class OOMObject {
	}
	
	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<>();
		int i=0;
		while (true){
			list.add(new OOMObject());
			System.out.println(i);
			i++;
		}
	}
}
