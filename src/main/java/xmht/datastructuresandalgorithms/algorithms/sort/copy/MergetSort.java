package xmht.datastructuresandalgorithms.algorithms.sort.copy;

/**
 * @author shengjk1
 * @date 2020/9/16
 */
public class MergetSort {
	public static void main(String[] args) {
		int[] arr = {1, 4, 3, 2, 5, 6};
		int[] temp = new int[arr.length];
		
	}
	
	public void process(int left, int right, int[] arr, int[] temp) {
		int mid = (left + right) / 2;
		process(left, mid, arr, temp);
		process(mid + 1, right, arr, temp);
		
	}
	
	public void merge(int left, int right, int[] arr, int[] temp) {
		while (left >= 0 && right >= 0) {
			if (arr[left] > arr[right]) {
			}
		}
	}
	
}
