package xmht.dataStructuresAndAlgorithms.orderalgorithm;

/**
 * Created by shengjk1 on 2017/6/12 0012
 */

/*
O(n^2)
if this data is basically ordered,insertSort is quickly
 */

public class InsertSort {
	public static void main(String[] args) {
		int[] a={0,21,2,3,45,-10};
		
		
		int out,in;
		int length=a.length-1;
		for (out = 1; out <= length; out++) {
			int temp=a[out];
			in=out;
			while (in>0 && a[in-1]>=temp){
				a[in]=a[in-1];
				--in;
			}
			a[in]=temp;
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
