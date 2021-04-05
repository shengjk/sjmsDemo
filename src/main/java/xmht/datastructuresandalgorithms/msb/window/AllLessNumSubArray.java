package xmht.datastructuresandalgorithms.msb.window;

import java.util.LinkedList;

/**
 * @author shengjk1
 * @date 2021/4/1
 * <p>
 * <p>
 * 给定一个整型数组arr，和一个整数num
 * 某个arr中的子数组sub，如果想达标，必须满足：
 * sub中最大值 – sub中最小值 <= num，
 * 返回arr中达标子数组的数量
 */
public class AllLessNumSubArray {

	public static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//头--> 尾  从大 ---> 小
		LinkedList<Integer> qmax = new LinkedList<>();
		// 头-->尾 从小 ---> 大
		LinkedList<Integer> qmin = new LinkedList<>();
		int L = 0;
		int R = 0;

		int rest = 0;

		// [L,R) R 是第一个不达标的位置
		while (L < arr.length) {

			while (R < arr.length) {
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
					qmax.pollLast();
				}
				qmax.addLast(R);

				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
					qmin.pollLast();
				}
				qmin.addLast(R);


				if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
					break;
				}
				R++;
			}

			//统计结果
			rest += R - L;
			// 判断L 是否过期
			if (qmax.peekFirst() == L) {
				qmax.pollFirst();
			}
			if (qmin.peekFirst() == L) {
				qmin.pollFirst();
			}

			L++;
		}
		return rest;
	}


	// for test
	public static int[] getRandomArray(int len) {
		if (len < 0) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{5, 5, 5, 4, 1, 0, 1, 6, 2, 8, 4, 2, 9, 5, 3, 3, 2, 8, 1, 1, 5, 4, 2, 9, 3, 8, 2, 3, 2, 2};
		System.out.println(getNum(arr, 5));

	}

}
