package xmht.zsda.handwriting.write;

/**
 * @author shengjk1
 * @date 2020/11/3
 */
/*
归并排序，递归
递归的方式，假设左边有序，假设右边有序，然后合并两个有序数组
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arrs = {1, 2, 9, 0, 3, 5, 6, 0, -8};
		process(arrs, 0, arrs.length - 1);
		for (int arr : arrs) {
			System.out.println(arr);
		}
	}
	
	public static void process(int[] arr, int left, int right) {
		if (left == right) {
			return;
		}
		int mid = (left + right) / 2;
		
		process(arr, left, mid);
		process(arr, mid + 1, right);
		mergeSort(arr, left, mid, right);
	}
	
	public static void mergeSort(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		
		int L = left;
		int R = mid + 1;
		int tmpIndex = 0;
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				temp[tmpIndex++] = arr[L++];
			} else {
				temp[tmpIndex++] = arr[R++];
			}
		}
		while (L <= mid) {
			temp[tmpIndex++] = arr[L++];
		}
		
		while (R <= right) {
			temp[tmpIndex++] = arr[R++];
		}
		
		L = left;
		for (int i = 0; i < temp.length; i++) {
			arr[L++] = temp[i];
		}
		
	}
}
