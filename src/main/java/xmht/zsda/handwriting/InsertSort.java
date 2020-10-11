package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/10/3
 */
/*
冒泡、插入、选择，都是 O(N^2) 只是后两者相对于冒泡来说，比较的更少一些

0-0 上有序
0-1 上有序
......
0-N 上有序
 */
public class InsertSort {
	
	public static void main(String[] args) {
		int[] arr = {10, 2, 0, 9, 3};
		insertSort(arr);
		for (int i : arr) {
			System.out.println("i = " + i);
		}
	}
	
	public static void insertSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int tmp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = tmp;
				}
			}
		}
	}
}
