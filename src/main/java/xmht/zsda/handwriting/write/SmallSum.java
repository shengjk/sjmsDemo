package xmht.zsda.handwriting.write;

/**
 * @author shengjk1
 * @date 2020/11/25
 */
public class SmallSum {
	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}
	
	public static int process(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = l + (r - 1) / 2;
		return process(arr, l, mid) + process(arr, mid + 1, r)
				+ merge(arr, l, mid, r);
	}
	
	public static int merge(int[] arr, int l, int m, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l;
		int p2 = m + 1;
		int res = 0;
		
		while (p1 <= m && p2 <= r) {
			res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1] : arr[p2];
		}
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		
		for (int j = 0; j < help.length; j++) {
			arr[l + 1] = help[i];
		}
		return res;
	}
}
