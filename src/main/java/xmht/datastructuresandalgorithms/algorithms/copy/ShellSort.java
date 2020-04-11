package xmht.datastructuresandalgorithms.algorithms.copy;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/4/9
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = {1, -2, 2, -3, 5, 0};
		
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			
			for (int j = gap; j < arr.length; j += gap) {
				int insertIndex = j;
				int insertValue = arr[insertIndex];
				
				while (insertIndex - gap >= 0 && arr[insertIndex - gap] > insertValue) {
					arr[insertIndex] = arr[insertIndex - gap];
					insertIndex -= gap;
				}
				arr[insertIndex] = insertValue;
				System.out.printf("第%d次遍历 insertIndex %d arr:%s", j, insertIndex, Arrays.toString(arr));
				System.out.println();
			}
		}
	}
}
