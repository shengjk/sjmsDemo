package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/26 0026
 */
public class ArrayPar {
	private long[] theArray;
	private int nElems;
	
	public ArrayPar(int max) {
		theArray=new long[max];
		nElems=0;
	}
	public void insert(long value){
		theArray[nElems]=value;
		nElems++;
	}
	public int size(){
		return nElems;
	}
	
	public void disaply(){
		System.out.println("A=");
		for (int j = 0; j < nElems; j++) {
			System.out.println(theArray[j]+" ");
		}
	}
	public int partitionIt(int left,int right,long pivot){
		int leftPtr=left-1;
		int rightPtr=right+1;
		
		while (true){
		}
	}
	
}
