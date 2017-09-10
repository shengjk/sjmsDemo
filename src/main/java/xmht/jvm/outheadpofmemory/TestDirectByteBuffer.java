package xmht.jvm.outheadpofmemory;

import java.nio.ByteBuffer;

/**
 * Created by shengjk1 on 2017/8/8
 */
//-verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M
public class TestDirectByteBuffer {
	public static void main(String[] args) {
		while (true){
			ByteBuffer buffer=ByteBuffer.allocateDirect(10*1024*1024);
		}
	}
}
