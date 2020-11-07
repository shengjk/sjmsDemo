package xmht.zsda.handwriting.write;

/**
 * @author shengjk1
 * @date 2020/11/3
 */
/*
over
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int[] arrs = {1, 2, 3, 4, 5, 6, 7};
		int left = 0;
		int right = arrs.length - 1;
		int search = 7;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arrs[mid] > search) {
				left = mid - 1;
			} else if (arrs[mid] < search) {
				left = mid + 1;
			} else {
				System.out.println("找到== index:" + mid);
				return;
			}
		}
	}
}
