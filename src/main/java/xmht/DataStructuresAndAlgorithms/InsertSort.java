package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */

/**
 * 大多数情况下，插入排序要比冒泡排序更快一倍，比选择排序还要快一点，虽然仍然需要O(n^2)
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] a = {1, 10, 2, 30, 4, 50, 2, 0, -1};
		int length = a.length;
		int out, in;
		for (out = 1; out < length; out++) {
			int temp = a[out];
			in = out;
			
			while (in > 0 && a[in - 1] >= temp) {
				a[in] = a[in - 1];
				--in;
			}
			a[in] = temp;
		}
		
		for (int i = 0; i < length; i++) {
			System.out.println(a[i]);
		}
	}
}
