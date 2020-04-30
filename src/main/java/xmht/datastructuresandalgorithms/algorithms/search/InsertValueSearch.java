package xmht.datastructuresandalgorithms.algorithms.search;

/**
 * @author shengjk1
 * @date 2020/4/16
 */
public class InsertValueSearch {
	public static void main(String[] args) {
//		int[] arr = {1, 1, 1, 1, 1, 1};
//		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int[] arr = {1, 12, 30, 400, 5000, 60000, 700000};
		int i = insertValueSearch(arr, 0, arr.length - 1, 400);
		System.out.println(i);
	}
	
	public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
		System.out.println("==");
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		
		int mid = 0;
		if ((arr[right] - arr[left]) != 0) {
			mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		} else {
			mid = left;
		}
		
		int midVal = arr[mid];
		if (findVal > midVal) {
			return insertValueSearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return insertValueSearch(arr, left, mid - 1, findVal);
		} else {
			return mid;
		}
		
	}
}
