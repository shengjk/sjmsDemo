package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/27 0027
 */
//内部排序或者随机存储器内的排序，大多数情况下是最快的
class ArrayIns{
	private long[] theArray;
	private int nElems;
	
	public ArrayIns(int max) {
		theArray=new long[max];
		nElems=0;
	}
	
	public void insert(long value){
		theArray[nElems]=value;
		nElems++;
	}
	public void display(){
		System.out.println("A===");
		for (int j = 0; j < nElems; j++) {
			System.out.println(theArray[j]+" ");
		}
	}
	
	public void recQuickSort(int left,int right){
		if (right-left<=0){
			return;
		}else {
			long pivot=theArray[right];
			int partition=partitionIt(left,right,pivot);
			recQuickSort(left,partition-1);
			recQuickSort(partition+1,right);
		}
	}
	
	public int partitionIt(int left,int right,long pivot){
		int leftPtr=left-1;
		int rightPtr=right;
		while (true){
			while (theArray[++leftPtr]<pivot){
			
			}
		}
	}
	
}
public class QuickSort1 {
}
