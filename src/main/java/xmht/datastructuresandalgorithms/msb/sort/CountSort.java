package xmht.datastructuresandalgorithms.msb.sort;

/**
 * @author shengjk1
 * @date 2021/2/17
 */
public class CountSort {

	//only for 0-200
	public static void countSort(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int i : arr) {
			max = Math.max(max, i);
		}

		int[] ints = new int[max + 1];

		for (int i : arr) {
			ints[i]++;
		}

		int index = 0;
		for (int i = 0; i < ints.length; i++) {
			while ((ints[i]--) > 0) {
				arr[index++] = i;
			}
		}
	}
}
