package xmht.datastructuresandalgorithms.msb.search;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2021/2/15
 */
public class BsNearRight {


	public static int bsNearRight(int[] arr, int value) {
		int L = 0;
		int R = arr.length - 1;
		int index = -1;

		while (L <= R) {
			int mid = (L + R) / 2;

			if (arr[mid] <= value) {
				index = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return index;
	}


	public static int test(int[] arr, int value) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] <= value) {
				return i;
			}
		}
		return -1;
	}

	public static int[] generateTandonArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
		}
		return arr;
	}

	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int testTime = 50000;
		int maxSize = 10;
		int maxValue = 1000;

		boolean succeed = true;

		for (int i = 0; i < testTime; i++) {
			int[] arr = generateTandonArray(maxSize, maxValue);
			Arrays.sort(arr);
			int value = (int) (((maxValue + 1) + Math.random()) - (int) (maxValue * Math.random()));

			if (test(arr, value) != bsNearRight(arr, value)) {
				printArray(arr);
				System.out.println(value);
				System.out.println(test(arr, value));
				System.out.println(bsNearRight(arr, value));
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}
}
