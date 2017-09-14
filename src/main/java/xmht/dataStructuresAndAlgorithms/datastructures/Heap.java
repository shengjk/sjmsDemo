package xmht.dataStructuresAndAlgorithms.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shengjk1 on 2017/9/13
 */

/*
堆，主要用来做优先级队列。用堆来实现的优先级队列，插入删除的时间复杂度都是O(logN)
假设最大值的关键字在根节点上，降序

采用数组来表示。
若数组中节点的索引为X,则
它的父节点的下标为(x-1)/2
它的左子节点的下标为2*x+1
它的右子节点的下标为2*x+2

在java中可以用Vector类对象取代数组对象，Vector类对象可以动态扩展
 */

class Node4{
	private int iData;
	
	public Node4(int key) {
		iData=key;
	}
	
	public int getKey(){
		return iData;
	}
	
	public void setKey(int id){
		iData=id;
	}
}

class Heap {
	private Node4[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public Heap(int mx) {
		maxSize=mx;
		currentSize=0;
		heapArray=new Node4[maxSize];
	}
	
	
	public boolean isEmpty()
	{ return currentSize==0; }
	
	
	public boolean insert(int key){
		if (currentSize==maxSize){
			return false;
		}
		Node4 newNode=new Node4(key);
		heapArray[currentSize]=newNode;
		trickleUp(currentSize++);
		return true;
	}
	
	public void trickleUp(int index){
		int parent=(index-1)/2;
		Node4 bottom=heapArray[index];
		while (index>0 &&heapArray[parent].getKey()<bottom.getKey()){
			heapArray[index]=heapArray[parent];
			index=parent;
			parent=(parent-1)/2;
		}
		heapArray[index]=bottom;
	}
	
	
	public void trickleDown(int index){
		int largerChild;
		Node4 top=heapArray[index];
		while (index<currentSize/2){
			int leftChild=2*index+1;
			int rightChild=leftChild+1;
			
			/*
			得分几种情况
			1.左右字节点都存在
			2.只有左节点存在
			3.只有右节点存在
			4.左右节点都不存在
			此处过于简单了
			 */
			if (rightChild<currentSize &&
					heapArray[leftChild].getKey()<heapArray[rightChild].getKey()){
				largerChild=rightChild;
			}else {
				largerChild=leftChild;
			}
			
			if (top.getKey()>=heapArray[largerChild].getKey()){
				break;
			}
			
			heapArray[index]=heapArray[largerChild];
			index=largerChild;
		}
		heapArray[index]=top;
	}
	
	
	/**
	 * 更改节点的优先级
	 * 1.先更改节点关键字的值
	 * 2.再把节点向上或者向下移动到适当的位置
	 * @param index
	 * @param newValue
	 * @return
	 */
	public boolean change(int index, int newValue)
	{
		if(index<0 || index>=currentSize)
			return false;
		int oldValue = heapArray[index].getKey(); // remember old
		heapArray[index].setKey(newValue);  // change to new
		
		if(oldValue < newValue)             // if raised,
			trickleUp(index);                // trickle it up
		else                                // if lowered,
			trickleDown(index);              // trickle it down
		return true;
	}  // end change()
	
	
	/*
	remove肯定remove的是root
	 */
	public Node4 remove(){
		Node4 root=heapArray[0];
		heapArray[0]=heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	
	
	// -------------------------------------------------------------
	public void displayHeap()
	{
		System.out.print("heapArray: ");    // array format
		for(int m=0; m<currentSize; m++)
			if(heapArray[m] != null)
				System.out.print( heapArray[m].getKey() + " ");
			else
				System.out.print( "-- ");
		System.out.println();
		// heap format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;                          // current item
		String dots = "...............................";
		System.out.println(dots+dots);      // dotted top line
		
		while(currentSize > 0)              // for each heap item
		{
			if(column == 0)                  // first item in row?
				for(int k=0; k<nBlanks; k++)  // preceding blanks
					System.out.print(' ');
			// display item
			System.out.print(heapArray[j].getKey());
			
			if(++j == currentSize)           // done?
				break;
			
			if(++column==itemsPerRow)        // end of row?
			{
				nBlanks /= 2;                 // half the blanks
				itemsPerRow *= 2;             // twice the items
				column = 0;                   // start over on
				System.out.println();         //    new row
			}
			else                             // next item on row
				for(int k=0; k<nBlanks*2-2; k++)
					System.out.print(' ');     // interim blanks
		}  // end for
		System.out.println("\n"+dots+dots); // dotted bottom line
	}  // end displayHeap()
// -------------------------------------------------------------
}  // end class Heap
////////////////////////////////////////////////////////////////
class HeapApp
{
	public static void main(String[] args) throws IOException
	{
		int value, value2;
		Heap theHeap = new Heap(31);  // make a Heap; max size 31
		boolean success;
		
		theHeap.insert(70);           // insert 10 items
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);
		
		while(true)                   // until [Ctrl]-[C]
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, remove, change: ");
			int choice = getChar();
			switch(choice)
			{
				case 's':                        // show
					theHeap.displayHeap();
					break;
				case 'i':                        // insert
					System.out.print("Enter value to insert: ");
					value = getInt();
					success = theHeap.insert(value);
					if( !success )
						System.out.println("Can't insert; heap full");
					break;
				case 'r':                        // remove
					if( !theHeap.isEmpty() )
						theHeap.remove();
					else
						System.out.println("Can't remove; heap empty");
					break;
				case 'c':                        // change
					System.out.print("Enter current index of item: ");
					value = getInt();
					System.out.print("Enter new key: ");
					value2 = getInt();
					success = theHeap.change(value, value2);
					if( !success )
						System.out.println("Invalid index");
					break;
				default:
					System.out.println("Invalid entry\n");
			}  // end switch
		}  // end while
	}  // end main()
	//-------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	//-------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
//-------------------------------------------------------------
}  // end class HeapApp
////////////////////////////////////////////////////////////////
