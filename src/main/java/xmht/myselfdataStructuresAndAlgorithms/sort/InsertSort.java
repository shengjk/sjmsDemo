package xmht.myselfdataStructuresAndAlgorithms.sort;

/**
 * Created by shengjk1 on 2017/6/12 0012
 */

/*
O(n^2)
if this data is basically ordered,insertSort is quickly
 */

/**
 * 表插入排序，就是把有序链表remove，插入数据中。与基于数组的插入排序相比，
 * 表插入排序有个缺点，就是它要开辟差不多两倍的空间。
 * 表插入排序对于不太大的数组排序还是比较便利的
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] a={0,21,2,3,45,-10};
		
		
		int in,out;
		for (out=0;out<=a.length-1;out++){
			int temp=a[out];
			in=out;
			while (in>0 && a[in-1]>temp){
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
