package xmht.zsda.handwriting.one;

/**
 * @author shengjk1
 * @date 2020/10/19
 */
public class BSExist {
	
	public static boolean binarySearch(int[] arr, int L, int R, int target) {
		if (L > R) {
			return false;
		}
		
		int mid = (L + R) / 2;
		if (target == arr[mid]) {
			return true;
		} else if (target > arr[mid]) {
			L = mid + 1;
			binarySearch(arr, L, R, target);
		} else {
			R = mid - 1;
			binarySearch(arr, L, R, target);
		}
		return false;
	}
	
	
	public static boolean binarySearch2(int[] arr, int L, int R, int target) {
		while (L <= R) {
			int mid = (L + R) / 2;
			if (target == arr[mid]) {
				return true;
			} else if (target > arr[mid]) {
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return false;
	}
}
