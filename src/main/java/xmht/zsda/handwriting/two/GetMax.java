package xmht.zsda.handwriting.two;

/**
 * @author shengjk1
 * @date 2020/10/19
 */
public class GetMax {
	public static int getMax(int[] arr) {
		return process(arr, 0, arr.length - 1);
	}
	
	public static int process(int[] arr, int L, int R) {
		if (L == R) {
			return arr[L];
		}
		
		int mid = (L + R) / 2;
		int leftMax = process(arr, L, mid);
		int rigthMax = process(arr, mid + 1, R);
		return Math.max(leftMax, rigthMax);
	}
}
