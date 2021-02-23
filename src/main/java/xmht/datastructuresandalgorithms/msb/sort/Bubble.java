package xmht.datastructuresandalgorithms.msb.sort;

/**
 * @author shengjk1
 * @date 2021/2/11
 */
public class Bubble {
	public static void main(String[] args) {
		int[] arr = {1, 0, 2, 9, 4, -1, 100, 10};
		System.out.println(arr.length);
		bubble(arr);
		for (int i : arr) {
			System.out.println("i = " + i);
		}
	}

	public static void bubble(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					swap(arr, j, i);
				}
			}
		}
	}

	//将 begin 与 end 交换
	public static void swap(int[] arr, int begin, int end) {
		int temp = arr[end];
		arr[end] = arr[begin];
		arr[begin] = temp;
	}

}
