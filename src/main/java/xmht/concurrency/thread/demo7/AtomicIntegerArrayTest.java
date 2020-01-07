package xmht.concurrency.thread.demo7;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author shengjk1
 * @date 2020/1/7
 */
public class AtomicIntegerArrayTest {
	static int[] value = new int[]{1, 2};
	//会对原数组复制一份，AtomicIntegerArray 对其进行修改，不会影响传入的数组
	static AtomicIntegerArray ai = new AtomicIntegerArray(value);
}
