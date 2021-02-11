package xmht.zsda.handwriting.five;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/10/11
 */
/*
根据键值的每位数字来分配桶
先个位，再十位 ...
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
		//找到最大值
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		//获取最大值的长度
		int maxLength = String.valueOf(max).length();
		//确定桶的长度
		int[][] bucket = new int[10][arr.length];
		//记录这个桶有多少个数
		int[] bucketElement = new int[arr.length];
		
		//先个位然后在十位然后百位，以此类推
		// n 通过 n*=10 来表示对哪位取余
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
