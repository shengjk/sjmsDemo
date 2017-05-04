package xmht.algorithm;

/**
 * Created by shengjk1 on 2017/2/14.
 */

/*
冒泡法排序会把最小的气泡推到最前面去(或者把最大的气泡推到最前面去)，时间复杂度为O(n^2)
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arr={1,2,10,3,5,0,9,7,8,6};
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j=arr.length-1;j>i;j--){
				if (arr[j]<arr[j-1]){
					int tmp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		
	}
}
