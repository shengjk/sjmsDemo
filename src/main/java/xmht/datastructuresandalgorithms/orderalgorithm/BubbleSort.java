package xmht.datastructuresandalgorithms.orderalgorithm;

/**
 * Created by shengjk1 on 2017/6/12 0012
 */

/*
 *compare O(n^2) move O(n^2)
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] a={0,21,2,3,45,-10};
		
		
		int out,in;
		int length=a.length;
		for (out =length-1 ; out >= 0; out--) {
			for (in=0;in<out;in++){
//				System.out.println(a);
//				System.out.println(in);
				if (a[in]>a[in+1]){
					int temp=a[in];
					a[in]=a[in+1];
					a[in+1]=temp;
				}
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public void bubbleSort(int length){
	
	}
	
}
