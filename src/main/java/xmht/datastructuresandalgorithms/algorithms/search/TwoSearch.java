package xmht.datastructuresandalgorithms.algorithms.search;

/**
 * @author shengjk1
 * @date 2020/4/14
 */
public class TwoSearch {
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9, 10, 20, 23};
		
		int searchValue = 70;
		int left = 0;
		int right = a.length - 1;
		
		boolean flat = false;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (a[mid] < searchValue) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			if (a[mid] == searchValue) {
				flat = true;
				break;
			}
		}
		if (flat) {
			System.out.println("找到");
		}
		
	}
	
	
	public static int binarySearch(int[] arr, int left, int right, int finVal) {
		if (left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		
		//向右递归
		if (finVal > midVal) {
			return binarySearch(arr, mid + 1, right, finVal);
		} else if (finVal < midVal) {
			return binarySearch(arr, left, mid - 1, finVal);
		} else {
			return mid;
		}
	}
}

