package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/10/2
 */

/**
 * 假设 0 位置是最小值，0-N-1 选择一个最小值，放到 0 位置
 * 假设 1 位置是最小值，1-N-1 选择一个最小值，放到 1 位置...
 * <p>
 * 相比于冒泡排序，只是减少了比较交换
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 10, 5, 0, 2, 9};
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		for (int i : arr) {
			System.out.println("i = " + i);
		}
	}
}
