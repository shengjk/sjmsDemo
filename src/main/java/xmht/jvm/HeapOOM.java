package xmht.jvm;

import java.util.ArrayList;

/**
 * @author shengjk1
 * @date 2020/9/12
 */
/*
-Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
	public static void main(String[] args) {
		ArrayList<OOMObject> oomObjects = new ArrayList<>();
		while (true) {
			oomObjects.add(new OOMObject());
		}
	}
	
	static class OOMObject {
	
	}
}
