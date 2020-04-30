package xmht.datastructuresandalgorithms.algorithms.sort.copy;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/4/9
 */
public class InsertSort {
	public static void main(String[] args) {
//		int[] arr = {1, -2, 2, -3, 5, 0};
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = (int) (Math.random() * 80000000);
		}
//		//insert sort
//		int insertIndex = 1;
//		int insertValue = arr[1];
//
//		while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertValue) {
//			arr[insertIndex] = arr[insertIndex - 1];
//			insertIndex--;
//		}
//		arr[insertIndex] = insertValue;
//		System.out.printf("第一次遍历 insertIndex %d arr:%s", insertIndex, Arrays.toString(arr));
//		System.out.println();
//
//		insertIndex = 2;
//		insertValue = arr[2];
//
//		while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertValue) {
//			arr[insertIndex] = arr[insertIndex - 1];
//			insertIndex--;
//		}
//		arr[insertIndex] = insertValue;
//		System.out.printf("第一次遍历 insertIndex %d arr:%s", insertIndex, Arrays.toString(arr));
//		System.out.println();
//
//		insertIndex = 3;
//		insertValue = arr[insertIndex];
//
//		while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertValue) {
//			arr[insertIndex] = arr[insertIndex - 1];
//			insertIndex--;
//		}
//		arr[insertIndex] = insertValue;
//		System.out.printf("第一次遍历 insertIndex %d arr:%s", insertIndex, Arrays.toString(arr));
//		System.out.println();
		
		
		for (int i = 1; i < arr.length; i++) {
			int insertIndex = i;
			int insertValue = arr[insertIndex];
			
			while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertValue) {
				arr[insertIndex] = arr[insertIndex - 1];
				insertIndex--;
			}
			arr[insertIndex] = insertValue;
			System.out.printf("第%d次遍历 insertIndex %d arr:%s", i, insertIndex, Arrays.toString(arr));
			System.out.println();
		}
	}
}
