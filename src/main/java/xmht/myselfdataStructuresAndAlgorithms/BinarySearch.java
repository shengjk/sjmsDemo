package xmht.myselfdataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/9/14
 */

/**
 * 三个指针，一个指向最小值，一个指向中间值，一个指向最大值
 */
public class BinarySearch {
	
	/*
	适用于升序
	 */
	public static int index(int key,int[] a){
		int lo=0;
		int hi=a.length-1;
		
		while (lo<=hi){
			int mid=lo+(hi-lo)/2;
			if (key>a[mid]){
				lo=mid+1;
			}else if (key<a[mid]){
				hi=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int a[]={9,8,7,6,5,4,3,2,1};
		System.out.println(index(1,a));
	}
}
