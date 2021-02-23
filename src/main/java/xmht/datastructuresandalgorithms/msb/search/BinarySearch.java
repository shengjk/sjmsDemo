package xmht.datastructuresandalgorithms.msb.search;

/**
 * @author shengjk1
 * @date 2021/2/11
 */
public class BinarySearch {

	public static void main(String[] args) {

	}

	public static int binarySearch(int[] arr, int left, int right, int result) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;

		if (arr[mid] > result) {
			return binarySearch(arr, left, mid - 1, result);
		} else if (arr[mid] < result) {
			return binarySearch(arr, mid + 1, right, result);
		} else {
			return mid;
		}
	}


}
