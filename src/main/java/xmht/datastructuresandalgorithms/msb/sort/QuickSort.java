package xmht.datastructuresandalgorithms.msb.sort;

/**
 * @author shengjk1
 * @date 2021/2/16
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {1, 0, 2, 10, 10, 11, 100, 10};
		partitions1(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("i = " + arr[i]);
		}

	}


	public static void partitions(int[] arr) {
		int L = 0;
		int R = arr.length - 2;
		int num = arr[arr.length - 1];

		while (L <= R) {
			if (arr[L] <= num) {
				L++;
			} else {
				swap(arr, L, R--);
			}
		}
		swap(arr, L, arr.length - 1);
	}


	public static void partitions1(int[] arr) {
		int L = 0;
		int R = arr.length - 2;
		int num = arr[arr.length - 1];
		int index = 0;

		while (index <= R) {
			if (arr[index] < num) {
				swap(arr, index, L);
				index++;
				L++;
			} else if (arr[index] == num) {
				index++;
			} else {
				swap(arr, index, R--);
			}
		}
		swap(arr, index, arr.length - 1);
	}


	public static void process(int[] arr, int L, int R) {
		if (L < R) {
			return;
		}
		swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
		partitions1(arr);
	}


	//将 begin 与 end 交换
	public static void swap(int[] arr, int begin, int end) {
		int temp = arr[end];
		arr[end] = arr[begin];
		arr[begin] = temp;
	}
}
