package xmht.myselfdataStructuresAndAlgorithms.sort;

/**
 * Created by shengjk1 on 2017/6/28
 */

/**
 * 希尔排序
 * 对于多大几千个数据项的，中等规模大小的数组排序表现良好
 * O(N*(logN)^2)
 * 一些专家提倡：差不多的任何排序工作在开始时都可以用希尔排序，若实际中证明它不够快，再改成快排
 */
class ArraySh{
	private long[] theArray;
	private int nElems;
	
	public long[] getTheArray() {
		return theArray;
	}
	
	public void setTheArray(long[] theArray) {
		this.theArray = theArray;
	}
	
	public ArraySh(int max) {
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
	
	public void display(){
		System.out.println("A========== ");
		for (int j = 0; j < nElems; j++) {
			System.out.println(theArray[j]+" ");
		}
	}
	
	public void shellSort(){
		int inner,outer;
		long temp;
		int h=1;
		while (h<=nElems/3){
			h=h*3+1;
		}
		while (h > 0) {
			for (outer = 0; outer < nElems; outer++) {
				temp=theArray[outer];
				inner=outer;
				while (inner>h-1 &&theArray[inner-h]>=temp){
					theArray[inner]=theArray[inner-h];
					inner-=h;
				}
				theArray[inner]=temp;
			}
			h=(h-1)/3;
		}
	}
}

class ShellSortApp{
	public static void main(String[] args) {
		int maxSize=10;
		ArraySh arr;
		arr=new ArraySh(maxSize);
		
		for (int i = 0; i < maxSize; i++) {
			long  n =(int)(Math.random()*99);
			arr.insert(n);
		}
		
		arr.display();
		arr.shellSort();
		arr.display();
	}
}

public class ShellSort {
}
