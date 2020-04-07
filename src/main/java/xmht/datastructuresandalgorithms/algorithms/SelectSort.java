package xmht.datastructuresandalgorithms.algorithms;

/**
 * @author shengjk1
 * @date 2020/3/30
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = {1, 10, 2, 30, -1};
		selectSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				minIndex = arr[i] < arr[j] ? i : j;
			}
			if (minIndex != i) {
				int tem = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tem;
			}
		}
	}
}
