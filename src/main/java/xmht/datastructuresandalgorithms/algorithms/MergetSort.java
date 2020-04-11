package xmht.datastructuresandalgorithms.algorithms;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/4/11
 */
public class MergetSort {
	public static void main(String[] args) {
		int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println(Arrays.toString(arr));
		
	}
	
	
	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			//向左递归
			mergeSort(arr, left, mid, temp);
			//向右递归
			mergeSort(arr, mid + 1, right, temp);
			//合并
			merge(arr, left, mid, right, temp);
		}
	}
	
	/**
	 * @param arr   原始数组
	 * @param left  要合并的数组的最左边
	 * @param mid   要合并的数组的中间
	 * @param right 要合并数组的最右边
	 * @param temp  临时数组
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		System.out.println("left:" + left + " right:" + right);
		//左边有序序列的初始索引
		int i = left;
		//右边有序序列的初始索引
		int j = mid + 1;
		//指向 temp 数组的当前索引
		int t = 0;
		
		//(一)
		//先把左右两边有序数据按照规则填充到 temp 数组中
		//知道左右两边的有序序列，有一边处理完毕为止
		while (i <= mid && j <= right) {
			//如果左边的有序序列的当前元素小于等于右边有序序列的当前元素
			//即将左边的当前元素填充到 temp 数组
			//然后自增
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t++;
				i++;
			} else {
				temp[t] = arr[j];
				t++;
				j++;
			}
			
		}
		
		/*
		(二)
		把剩余数据的一边的数据依次全部填充到 temp 中
		 */
		while (i <= mid) {
			temp[t] = arr[i];
			t++;
			i++;
		}
		
		while (j <= right) {
			temp[t] = arr[j];
			t++;
			j++;
		}
		
		/*
		(三)
		将 temp 数组的元素拷贝到 arr
		注意，并不是每次都拷贝所有
		 */
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t++;
			tempLeft++;
		}
	}
}
