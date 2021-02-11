package xmht.zsda.handwriting.write;

/**
 * @author shengjk1
 * @date 2020/11/23
 */
public class QuickSort {
	public static int partition(int[] arr, int L, int R) {
		if (L > R) {
			return -1;
		}
		if (L == R) {
			return L;
		}
		int lessEqual = L - 1;
		int index = L;
		while (index <= R) {
			if (arr[index] <= arr[R]) {
				swap(arr, index, ++lessEqual);
			}
			index++;
		}
		return lessEqual;
	}
	
	public static void process(int[] arr, int L, int R) {
		if (arr == null) {
			return;
		}
		int m = partition(arr, 0, arr.length);
		process(arr, L, m - 1);
		process(arr, m + 1, R);
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
}
