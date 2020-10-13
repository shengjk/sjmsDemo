package xmht.zsda.handwriting.five;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/10/11
 */
public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {4, 10, 2, 100, 20};
//		int[] arr = new int[8];
//		for (int i = 0; i < 8; i++) {
//			arr[i] = (int) (Math.random() * 8000000);
//		}
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void radixSort(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		int maxLength = String.valueOf(max).length();
		
		int[][] bucket = new int[10][arr.length];
		int[] bucketElement = new int[arr.length];
		
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			
			for (int i1 : arr) {
				int result = i1 / n % 10;
				bucket[result][bucketElement[result]] = i1;
				bucketElement[result]++;
			}
			
			int index = 0;
			for (int i1 = 0; i1 < bucketElement.length; i1++) {
				if (bucketElement[i1] != 0) {
					for (int i2 = 0; i2 < bucketElement[i1]; i2++) {
						arr[index++] = bucket[i1][i2];
					}
				}
				bucketElement[i1] = 0;
			}
		}
	}
}
