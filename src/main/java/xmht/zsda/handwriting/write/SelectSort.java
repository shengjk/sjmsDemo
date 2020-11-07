package xmht.zsda.handwriting.write;

/**
 * @author shengjk1
 * @date 2020/11/3
 */
/*
O(N^2) 不稳定
1.假设 0 上是最小值，0-N-1 上选择最小值，放入到 0 位置上
2.假设 1 上是最小值，1-N-1 上选择最小值，放入到 1 位置上

相对于 BubbletSort 来说，减少了交换的次数，故比冒泡排序快

over
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arrs = {1, 3, 2, 9, 0, 5};
		for (int i = 0; i < arrs.length; i++) {
			int mixIndex = i;
			for (int j = i; j < arrs.length; j++) {
				if (arrs[mixIndex] > arrs[j]) {
					mixIndex = j;
				}
			}
			int tmp = arrs[i];
			arrs[i] = arrs[mixIndex];
			arrs[mixIndex] = tmp;
		}
		
		for (int arr : arrs) {
			System.out.println(arr);
		}
	}
}
