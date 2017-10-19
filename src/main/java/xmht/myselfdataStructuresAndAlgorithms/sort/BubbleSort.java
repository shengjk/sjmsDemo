package xmht.myselfdataStructuresAndAlgorithms.sort;

/**
 * Created by shengjk1 on 2017/6/12 0012
 */

/*
 *compare O(n^2) move O(n^2)
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] a={0,21,2,3,45,-10};
		
		
		int in,out;
		for (out=a.length-1;out>=0;out--){
			for (in=0;in<out;in++){
				if (a[in]<a[in+1]){
					int temp=a[in+1];
					a[in+1]=a[in];
					a[in]=temp;
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
