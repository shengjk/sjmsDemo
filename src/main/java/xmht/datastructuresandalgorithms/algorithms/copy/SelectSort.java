package xmht.datastructuresandalgorithms.algorithms.copy;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/4/9
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {1, -2, 2, -3, 5, 0};
		// arr
//
//		int minIndex = 0;
//		for (int i = 0 + 1; i < arr.length; i++) {
//			if (arr[minIndex] > arr[i]) {
//				minIndex = i;
//			}
//		}
//		int temp = arr[0];
//		arr[0] = arr[minIndex];
//		arr[minIndex] = temp;
//
//		System.out.printf("第一次遍历 minIndex %d ,arr=%s", minIndex, Arrays.toString(arr));
//
		
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		System.out.printf("遍历结果 arr=%s", Arrays.toString(arr));
	}
}
