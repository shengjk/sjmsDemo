package xmht.datastructuresandalgorithms.sort;

/**
 * @author shengjk1
 * @date 2019-05-16
 */
public class insertSort {
	public static void main(String[] args) {
		int[] a = {0, -1, 5, 10, 100, 2, 8, 3, 4};
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j >0 ; j--) {
				if (a[j]<a[j-1]){
					int tmp=a[j-1];
					a[j-1]=a[j];
					a[j]=tmp;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
