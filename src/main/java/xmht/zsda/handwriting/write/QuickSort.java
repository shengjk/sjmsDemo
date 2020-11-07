package xmht.zsda.handwriting.write;

/**
 * @author shengjk1
 * @date 2020/11/3
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arrs = {1, 5, 8, 9, 0, 4, 3, 2, -1};
		LessEquesMore(arrs, 0, arrs.length - 1);
		
		for (int arr : arrs) {
			System.out.println(arr);
		}
	}
	
	public static int LessEquesMore(int[] arr, int L, int R) {
		if (L > R) {
			return -1;
		}
		if (L == R) {
			return L;
		}
		
		int index = L;
		int left = L - 1;
		int right = R - 1;
		while (left < right) {
			if (arr[index] <= arr[R]) {
				index++;
				left++;
			}
		}
		return 0;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
