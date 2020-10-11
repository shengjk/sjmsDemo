package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/10/4
 */

/**
 * 归并排序 N*logN
 * <p>
 * 一半有序，另一半有序，然后合并两个有序，递归
 */
public class MergeSort {
	public static void main(String[] args) {
		
	}
	
	public static void process(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = (L + R) / 2;
		process(arr, L, mid);
		process(arr, mid + 1, R);
		mergeSort(arr, L, mid, R);
	}
	
	public static void mergeSort(int[] arr, int L, int mid, int R) {
		int[] tmp = new int[R - L + 1];
		int left = L;
		int right = mid + 1;
		int tmpIndex = 0;
		while (left <= mid && right <= R) {
			if (arr[left] <= arr[right]) {
				tmp[tmpIndex] = arr[left];
				left++;
			} else {
				tmp[tmpIndex] = arr[right];
				right++;
			}
			tmpIndex++;
		}
		
		while (left <= mid) {
			tmp[tmpIndex++] = arr[left++];
		}
		
		while (right <= R) {
			tmp[tmpIndex++] = arr[right++];
		}
		
		left = L;
		for (int i = 0; i < tmpIndex; i++) {
			arr[left] = tmp[i];
			left++;
		}
	}
}
