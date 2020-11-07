package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/10/4
 */

/**
 * 归并排序 N*logN
 * <p>
 * 一半有序，另一半有序，然后合并两个有序，递归
 */
public class MergeSort {
	
	// 递归方法实现
	public static void mergeSort1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		process(arr, 0, arr.length - 1);
	}
	
	public static void process(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = (L + R) / 2;
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

//	public static void merge(int[] arr, int L, int mid, int R) {
//		int[] tmp = new int[R - L + 1];
//		int left = L;
//		int right = mid + 1;
//		int tmpIndex = 0;
//		while (left <= mid && right <= R) {
//			if (arr[left] <= arr[right]) {
//				tmp[tmpIndex] = arr[left];
//				left++;
//			} else {
//				tmp[tmpIndex] = arr[right];
//				right++;
//			}
//			tmpIndex++;
//		}
//
//		while (left <= mid) {
//			tmp[tmpIndex++] = arr[left++];
//		}
//
//		while (right <= R) {
//			tmp[tmpIndex++] = arr[right++];
//		}
//
//		left = L;
//		for (int i = 0; i < tmpIndex; i++) {
//			arr[left] = tmp[i];
//			left++;
//		}
//	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
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
	
	// 非递归方法实现
	public static void mergeSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int N = arr.length;
		int mergeSize = 1;
		while (mergeSize < N) {
			int L = 0;
			while (L < N) {
				int M = L + mergeSize - 1;
				if (M >= N) {
					break;
				}
				int R = Math.min(M + mergeSize, N - 1);
				merge(arr, L, M, R);
				L = R + 1;
			}
			if (mergeSize > N / 2) {
				break;
			}
			mergeSize <<= 1;
		}
	}
	
	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	
	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort1(arr1);
			mergeSort2(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Oops!");
	}
	
}

