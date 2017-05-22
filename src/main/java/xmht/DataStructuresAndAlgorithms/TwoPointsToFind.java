package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */
//二分法必须在一个排序的数据里
public class TwoPointsToFind {
	public static void main(String[] args) {
		int[] a ={1,10,2,30,4,50,2,0};
		int length=a.length;
		
		int searchKey=40;
		
		int lowerBound=0;
		int upperBound=length-1;
		int curIn;
		
		while (true){
			curIn=(lowerBound+upperBound)/2;
			if(a[curIn]==searchKey){
				System.out.println("curIn "+curIn);
				return;
			}else if(lowerBound>upperBound){
				System.out.println("Error");
				return;
			}else {
				if(a[curIn]<searchKey){
					lowerBound=curIn+1;
				}else{
					upperBound=curIn-1;
				}
			}
		}
	}
}
