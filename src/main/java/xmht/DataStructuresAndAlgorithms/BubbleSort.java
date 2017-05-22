package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */
//O(n^2)
public class BubbleSort {
	public static void bubbleSort(){
		int[] a ={1,10,2,30,4,50,2,0};
		int length=a.length;
		for (int out = length-1; out > 0; out--) {
			for (int in = 0; in < out; in++) {
				if(a[in]>a[in+1]){
					int temp=a[in];
					a[in]=a[in+1];
					a[in+1]=temp;
				}
			}
		}
		
		for (int i = 0; i <a.length ; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		bubbleSort();
	}
}
