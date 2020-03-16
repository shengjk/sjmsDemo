package xmht.datastructuresandalgorithms.sort;

/**
 * @author shengjk1
 * @date 2019-05-16
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] a = {0, -1, 5, 10, 100, 2, 8, 3, 4};

//		for (int i = a.length-1; i >=0; i--) {
//			for (int j = 0; j < i; j++) {
//				if (a[j]>a[j+1]){
//					int tem=a[j+1];
//					a[j+1]=a[j];
//					a[j]=tem;
//				}
//			}
//		}
//
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int tem = a[j];
					a[j] = a[i];
					a[i] = tem;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}
}
