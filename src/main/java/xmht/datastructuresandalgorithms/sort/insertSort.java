package xmht.datastructuresandalgorithms.sort;

/**
 * @author shengjk1
 * @date 2019-05-16
 */

/**
 * 插入排序：
 * 把 n 个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表表中包含 n-1 个元素，
 * 排序过程中每次
 */
public class insertSort {
	public static void main(String[] args) {
		int[] a = {0, -1, 5, 10, 100, 2, 8, 3, 4};
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int tmp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = tmp;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
