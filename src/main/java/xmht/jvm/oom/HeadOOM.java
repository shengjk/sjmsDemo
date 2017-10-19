package xmht.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjk1 on 2017/8/8
 */
//-verbose:gc -XX:+PrintGCDetails  -Xmn10M -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\syph\Desktop\gc.hprof
public class HeadOOM {
	public static void main(String[] args) {
		List<byte[]> buffer = new ArrayList<byte[]>();
		buffer.add(new byte[10*1024*1024]);
	}
}
