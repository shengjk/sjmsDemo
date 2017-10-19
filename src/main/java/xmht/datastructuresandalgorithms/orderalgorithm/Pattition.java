package xmht.datastructuresandalgorithms.orderalgorithm;

/**
 * Created by shengjk1 on 2017/6/28
 */

/**
 * O(N)
 */
class ArrayPar1 extends ArraySh{
	
	public ArrayPar1(int max) {
		super(max);
	}
	
	public int partitionIt(int left,int right,long pivot){
		int leftPtr=left-1;
		int rightPtr=right+1;
		while (true){
		
			while (leftPtr<right && this.getTheArray()[++leftPtr]<pivot){
			
			}
			
			while (rightPtr>left && this.getTheArray()[--rightPtr]>pivot){
			
			}
			if (leftPtr>=rightPtr){
				break;
			}else {
				swap(leftPtr,rightPtr);
			}
		}
		return leftPtr;
	}
	
	public void swap(int dex1,int dex2){
		long temp;
		temp=this.getTheArray()[dex1];
		this.getTheArray()[dex1]=this.getTheArray()[dex2];
		this.getTheArray()[dex2]=temp;
	}
}

class PartitionAPP{
	public static void main(String[] args) {
		int maxSize=16;
		ArrayPar1 arr;
		arr=new ArrayPar1(maxSize);
		
		for (int j = 0; j < maxSize; j++) {
			long n=(int)(java.lang.Math.random()*199);
			arr.insert(n);
		}
		arr.display();
		
		long pivot=99;
		int size=arr.size();
		int partDex=arr.partitionIt(0,size-1,pivot);
		System.out.println("========== "+partDex);
		arr.display();
	}
}

public class Pattition {

}
