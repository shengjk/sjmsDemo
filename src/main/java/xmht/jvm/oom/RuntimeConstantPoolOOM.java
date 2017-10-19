package xmht.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjk1 on 2017/8/9
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		int i=0;
		while (true){
			list.add(String.valueOf(i++).intern());
		}
		
	}
}
