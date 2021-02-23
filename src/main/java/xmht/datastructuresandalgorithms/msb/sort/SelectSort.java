package xmht.datastructuresandalgorithms.msb.sort;

/**
 * @author shengjk1
 * @date 2021/2/11
 */
/*
选择排序跟冒泡排序很像，选择排序是对冒泡排序的优化，减少了交换的次数
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {1, 0, 2, 9, 4, -1, 100, 10};
		selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("i = " + arr[i]);
		}

	}

	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = 0; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					i = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}


	//将 begin 与 end 交换
	public static void swap(int[] arr, int begin, int end) {
		int temp = arr[end];
		arr[end] = arr[begin];
		arr[begin] = temp;
	}
}
