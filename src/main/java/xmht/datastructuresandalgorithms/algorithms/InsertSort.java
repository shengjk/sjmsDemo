package xmht.datastructuresandalgorithms.algorithms;

/**
 * @author shengjk1
 * @date 2020/4/3
 */
public class InsertSort {
	public static void main(String[] args) {
//		int[] arr = {1, 2, 10, -1, 3, 0};
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000000);
		}
		
		long start = System.currentTimeMillis();
		for (int i = 1; i < arr.length; i++) {
			int insertVale = arr[i];
			for (int j = i - 1; j >= 0; j--) {
				if (insertVale < arr[j]) {
					arr[j + 1] = arr[j];
					arr[j] = insertVale;
				} else {
					break;
				}
			}
		}
//		insertSort(arr);
		long end = System.currentTimeMillis();
		System.out.println((start - end) / 1000.0 + " s");
		
	}
	
	public static void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			int insertIndex = i - 1;
			
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex + 1] = insertVal;
			
		}
	}
	
}
