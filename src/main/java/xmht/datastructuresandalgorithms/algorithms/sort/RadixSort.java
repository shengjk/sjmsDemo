package xmht.datastructuresandalgorithms.algorithms.sort;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/4/11
 */
public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {4, 10, 2, 100, 20};
//		int[] arr = new int[8];
//		for (int i = 0; i < 8; i++) {
//			arr[i] = (int) (Math.random() * 8000000);
//		}
		radixSOrt(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void radixSOrt(int[] arr) {
		//1.得到数组中最大的数的位数
		//假设第一个数是最大的数
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = String.valueOf(max).length();
		
		
		
		/*
			定义一个二维数组，表示10个桶，每个桶就是一个一维数组
			1.二维数组包好10个一维数组
			2.为了防止放入数据时溢出，规定每个桶的大小为 arr.length
			3.基数排序是使用空间换时间的经典算法
			 */
		int[][] bucket = new int[10][arr.length];
		
		//为了记录每个桶中实际上放了多少个数据，定义一个一维数组来记录各个桶的每次放入
		//数据的个数
		int[] bucketElementCounts = new int[10];
		
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			
			//往桶中存数据，第一次是个位，第二次是十位，依次类推
			for (int j = 0; j < arr.length; j++) {
				//取对应位置上的数
				int digitOfElement = arr[j] / n % 10;
				
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			//按照桶的顺序取数据
			int index = 0;
			for (int k = 0; k < bucketElementCounts.length; k++) {
				//当桶中有数据
				if (bucketElementCounts[k] != 0) {
					for (int l = 0; l < bucketElementCounts[k]; l++) {
						arr[index++] = bucket[k][l];
					}
				}
				//从桶中取完数据后将其数据个数置为0
				bucketElementCounts[k] = 0;
			}
		}
	}
}
