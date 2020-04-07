package xmht.datastructuresandalgorithms.algorithms;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/4/3
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
		shellSort(arr);
	}
	
	public static void shellSort(int[] arr) {
		int count = 0;
		int temp = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
			System.out.println("第 " + (count++) + "轮 " + Arrays.toString(arr));
		}
	}
}
