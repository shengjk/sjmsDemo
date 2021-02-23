package xmht.datastructuresandalgorithms.msb.sort;

/**
 * @author shengjk1
 * @date 2021/2/15
 */
public class MergeSort {

	public static void main(String[] args) {
	}


	public static void mergeSort(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = (L + R) / 2;
		mergeSort(arr, L, mid);
		mergeSort(arr, mid + 1, R);

		merge(arr, L, mid, R);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int[] tmpArr = new int[right - left + 1];
		int L = left;
		int M = mid + 1;

		int i = 0;
		while (L <= mid && M <= right) {
			tmpArr[i++] = arr[L] <= arr[M] ? arr[L++] : arr[M++];
		}

		while (L <= mid) {
			tmpArr[i++] = arr[L++];
		}

		while (M <= right) {
			tmpArr[i++] = arr[M++];
		}


		L = left;
		for (int j = 0; j < tmpArr.length; j++) {
			arr[L++] = tmpArr[j];
		}
	}
}
