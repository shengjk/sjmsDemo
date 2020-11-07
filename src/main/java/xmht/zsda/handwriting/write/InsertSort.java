package xmht.zsda.handwriting.write;

/**
 * @author shengjk1
 * @date 2020/11/3
 */
/*
 对 0-0 进行有序
 对 0-1 进行有序
 对 0-2 进行有序
 ...
 对 0-N 进行有序
 
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arrs = {1, 2, 9, 0, 3, 5, 6, 0, -8};
		
		for (int i = 0; i < arrs.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arrs[j] < arrs[j - 1]) {
					int temp = arrs[j];
					arrs[j] = arrs[j - 1];
					arrs[j - 1] = temp;
				}
			}
		}
		for (int arr : arrs) {
			System.out.println(arr);
		}
	}
}
