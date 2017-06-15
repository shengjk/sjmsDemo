package xmht.dataStructuresAndAlgorithms.orderalgorithm;

/**
 * Created by shengjk1 on 2017/6/12 0012
 */

/*
 *find the min element,then assign the minimun value to
 * corresponding location
 *
 * compare O(n^2) exchange O(n)
 * 当n较少时，特别是如果交换时间级比比较的时间级大得多时，选择排序别冒泡是快的
 */

public class SelectSort {
	public static void main(String[] args) {
		int[] a={0,21,2,3,45,-10};
		
		
		int out,in,min;
		int length=a.length-1;
		for (out =0 ; out <= length; out++) {
			min=out;
			for (in=out+1;in<=length;in++){
				if (a[in]<a[min]){
					min=in;
				}
			}
			int temp=a[out];
			a[out]=a[min];
			a[min]=temp;
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
