package xmht.datastructuresandalgorithms.algorithms.search;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/4/21
 */
public class FibobacciSearch {
	
	public static int maxSize = 20;
	
	public static void main(String[] args) {
		int[] arr = {1, 8, 10, 89, 1000, 1234};
		System.out.println(Arrays.toString(fib()));
	}
	
	//[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765]
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
	
	
}
