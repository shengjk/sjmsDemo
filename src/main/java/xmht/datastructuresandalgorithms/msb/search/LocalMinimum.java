package xmht.datastructuresandalgorithms.msb.search;

/**
 * @author shengjk1
 * @date 2021/2/15
 */
public class LocalMinimum {
	public static void main(String[] args) {

	}

	public static int localMin(int[] arr) {

		if (arr == null) {
			return -1;
		}

		if (arr.length == 1) {
			return arr[0];
		}

		if (arr[0] < arr[1]) {
			return arr[0];
		}

		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr[arr.length - 2];
		}

		int L = 1;
		int R = arr.length - 1;
		int minIndex = -1;
		while (L <= R) {
			int mid = (L + R) / 2;

			if (arr[mid] > arr[mid - 1]) {
				R = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				L = mid + 1;
			} else {
				return mid;
			}
		}
		return L;
	}
}
