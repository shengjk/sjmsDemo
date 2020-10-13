package xmht.zsda.handwriting.five;

/**
 * @author shengjk1
 * @date 2020/10/11
 */
/*
计数排序， 以空间换时间的算法，记录该元素是否出现过
适用于有限范围的数组，正数
 */

public class CountSort {
	
	public static void countSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		
		//获取到数组的最大值
		int max = Integer.MAX_VALUE;
		for (int i : arr) {
			max = Math.max(max, i);
		}
		
		int[] bucket = new int[max + 1];
		for (int i : arr) {
			bucket[arr[i]]++;
		}
		
		int i = 0;
		for (int j : bucket) {
			while (j-- > 0) {
				arr[i++] = j;
			}
		}
	}
}
