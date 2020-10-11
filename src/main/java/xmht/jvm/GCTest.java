package xmht.jvm;

/**
 * -server -Xms1024m -Xmx1024m -Xmn384m -XX:+UseParallelOldGC
 * -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCDateStamps -XX:+PrintGCDetails
 * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=c:/heap.bin
 * <p>
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:PrintGCDetails -XX:SurvivorRatio=8
 */
public class GCTest {
	private static final int _1mb = 1024 * 1024;
	
	public static void main(String[] args) {
//		byte[] value1 = new byte[_1mb * 100];
//		byte[] value2 = new byte[_1mb * 100];
//		byte[] value3 = new byte[_1mb * 100];
//		new Thread() {
//			public void run() {
//				byte[] value4 = new byte[_1mb * 400];
//			}
//		}.start();
//		byte[] value5 = new byte[_1mb * 200];
		testAllocation();
	}
	
	public static void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1mb * 2];
		allocation2 = new byte[_1mb * 2];
		allocation3 = new byte[_1mb * 2];
		allocation4 = new byte[_1mb * 4];
	}
}  