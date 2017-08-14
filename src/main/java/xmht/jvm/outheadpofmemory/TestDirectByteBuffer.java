package xmht.jvm.outheadpofmemory;

import java.nio.ByteBuffer;

/**
 * Created by shengjk1 on 2017/8/8
 */
public class TestDirectByteBuffer {
	public static void main(String[] args) {
		//-verbose:gc -XX:+PrintGCDetails -XX:MaxDirectMemorySize=40M
		while (true){
			ByteBuffer buffer=ByteBuffer.allocateDirect(10*1024*1024);
		}
	}
}
