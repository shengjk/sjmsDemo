package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/26
 */
public class CardList {


	/*
	L...R 先手
	 */
	public static int f(int[] arr, int L, int R) {
		//剩最后一张牌了
		if (L == R) {
			return arr[L];
		}

		return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
	}

	/*
	L...R 后手
	 */
	public static int s(int[] arr, int L, int R) {
		if (L == R) {
			return 0;
		}
		return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
	}

	
	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	public static void main(String[] args) {
		int[] arr = {4, 7, 9, 5, 19, 29, 80, 4};
		// A 4 9
		// B 7 5
		System.out.println(win1(arr));

	}
}
