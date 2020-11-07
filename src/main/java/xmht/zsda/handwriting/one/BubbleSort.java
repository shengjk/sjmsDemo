package xmht.zsda.handwriting.one;

/**
 * @author shengjk1
 * @date 2020/11/2
 */
/*
O(N^2) O(1) 不具备稳定性
大就交换
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 3, 0, 5};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
