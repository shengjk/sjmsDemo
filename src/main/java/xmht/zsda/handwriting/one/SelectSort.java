package xmht.zsda.handwriting.one;

/**
 * @author shengjk1
 * @date 2020/11/2
 */
/*
O(N^2) O(1) 具备稳定性
假设 0 为位置是最小值，在 0-N-1 上选择一个最小值，与 0 位置交换
假设 1 位置是最小值，在 1-N-1 上选择一个最小值，与 1 位置交换
选择最小值，然后与之交换
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 0, 5};
		
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
