package xmht.datastructuresandalgorithms.msb.sort;

/**
 * @author shengjk1
 * @date 2021/2/13
 */

/*
插入排序
0-1 上有序
0-2 有序
0-i 有序
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {1, 0, 2, 9, 4, -1, 100, 10};
		insertSort(arr);

		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static void insertSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}


	//将 begin 与 end 交换
	public static void swap(int[] arr, int begin, int end) {
		int temp = arr[end];
		arr[end] = arr[begin];
		arr[begin] = temp;
	}
}
