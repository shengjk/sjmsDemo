package xmht.datastructuresandalgorithms.algorithms.sort;

/**
 * @author shengjk1
 * @date 2020/4/9
 */
public class QuickSort {
	public static void main(String[] args) {
//		int[] arr = {-9, 78, 0, 23, -567, 70};
		
		int[] arr = new int[80000000];
		for (int i = 0; i < 80000000; i++) {
			arr[i] = (int) (Math.random() * 80000000);
		}
		
		quickSOrt(arr, 0, arr.length - 1);
//		System.out.println("arr " + Arrays.toString(arr));
	}
	
	public static void quickSOrt(int[] arr, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[(l + r) / 2];
		int temp = 0;
		//while 循环的目的就是让比 pivot
		while (l < r) {
			//在 pivot 的左边一直找，找打大于等于 pivot 值，才退出
			while (arr[l] < pivot) {
				l++;
			}
			//在 pivot 的右边一直找，找到小于等于 pivot 值，才退出
			while (arr[r] > pivot) {
				r--;
			}
			
			//说明 pivot 的左右两值，已经按照左边全部是小于等于 pivot 值，右边全部大于等于 pivot 值。
			if (l >= r) {
				break;
			}
			
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			//如果交换完成后，发现 arr[i] == pivot r--，前移
			if (arr[l] == pivot) {
				r--;
			}
			if (arr[r] == pivot) {
				l++;
			}
		}
		
		
		if (l == r) {
			l++;
			r--;
		}
		
		// 向左递归
		if (left < r) {
			quickSOrt(arr, left, r);
		}
		
		if (right > l) {
			quickSOrt(arr, l, right);
		}
	}
}
