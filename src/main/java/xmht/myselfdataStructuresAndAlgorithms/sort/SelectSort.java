package xmht.myselfdataStructuresAndAlgorithms.sort;

/**
 * Created by shengjk1 on 2017/6/12 0012
 */

/*
 *find the min element,then assign the minimun value to
 * corresponding location
 *
 * compare O(n^2) exchange O(n)
 * 当n较少时，特别是如果交换时间级比比较的时间级大得多时，选择排序别冒泡是快的
 *
 * 只找最矮的，跟最左边未排序的进行交换
 *
 * 内循环在外循环的子集里面找到最小值，然后在外循坏中把最小值放到相应位置
 */

	
public class SelectSort {
	public static void main(String[] args) {
		int[] a={0,21,2,3,45,-10};
		
		
		int in,out,min;
		for (out=0;out<a.length;out++){
			min=out;
			for (in=out+1;in<a.length;in++){
				if(a[in]<a[min]){
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
