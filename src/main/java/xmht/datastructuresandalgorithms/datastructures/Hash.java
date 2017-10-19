package xmht.datastructuresandalgorithms.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shengjk1 on 2017/9/10.
 *
 * O(1)
 */

class DataItem{
	private  int iData;
	
	public DataItem(int iData) {
		this.iData = iData;
	}
	
	public  int getKey(){
		return iData;
	}
}

class HashTable{
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem; //for deleted items
	
	public HashTable(int arraySize) {
		this.arraySize = arraySize;
		hashArray=new DataItem[arraySize];
		nonItem=new DataItem(-1);
	}
	
	public void  displayTable(){
		System.out.println("table :");
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i]!=null){
				System.out.println(hashArray[i].getKey()+" ");
			}else {
				System.out.println("** ");
			}
			System.out.println();
		}
	}
	
	public int hashFunc(int key){
		return key%arraySize;
	}
	
	public int hashFuc2(int key){
		return 5-key*5;
	}
	
	public void insert(DataItem item){
		int key=item.getKey();
		int hashVal=hashFunc(key);
		
		while (hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1){
			++hashVal;
			hashVal%=arraySize;
		}
		hashArray[hashVal]=item;
	}
	
	
	//再哈希，要求表的容量是一个质数
	public void insert2(int key, DataItem item){
		int hashVal=hashFunc(key);
		int stepSize=hashFuc2(hashVal);
		
		while (hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1){
			hashVal +=stepSize;
			hashVal %=arraySize;
		}
		hashArray[hashVal]=item;
	}
	
	
	public DataItem delete(int key){
		int hasVal=hashFunc(key);
		
		while (hashArray[hasVal]!=null){//有可能会一直while下去
			if (hashArray[hasVal].getKey()==key){
				DataItem temp =hashArray[hasVal];
				hashArray[hasVal]=nonItem;
				return temp;
			}
			++hasVal;
			hasVal %=arraySize;
		}
		return null;
	}
	
	public DataItem find(int key){
		int hasVal=hashFunc(key);
		
		while (hashArray[hasVal]!=null){
			if (hashArray[hasVal].getKey()==key){
				return hashArray[hasVal];
			}
			++hasVal;
			hasVal %=arraySize;
		}
		return null;
	}
}
//所有的while都有可能一直循环下去
class HashApp{
	public static void main(String[] args) throws IOException
	{
		DataItem aDataItem;
		int aKey, size, n, keysPerCell;
		// get sizes
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		keysPerCell = 10;
		// make table
		HashTable theHashTable = new HashTable(size);
		
		for(int j=0; j<n; j++)        // insert data
		{
			aKey = (int)(java.lang.Math.random() *
					keysPerCell * size);
			aDataItem = new DataItem(aKey);
			theHashTable.insert(aDataItem);
		}
		
		while(true)                   // interact with user
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = getChar();
			switch(choice)
			{
				case 's':
					theHashTable.displayTable();
					break;
				case 'i':
					System.out.print("Enter key value to insert: ");
					aKey = getInt();
					aDataItem = new DataItem(aKey);
					theHashTable.insert(aDataItem);
					break;
				case 'd':
					System.out.print("Enter key value to delete: ");
					aKey = getInt();
					theHashTable.delete(aKey);
					break;
				case 'f':
					System.out.print("Enter key value to find: ");
					aKey = getInt();
					aDataItem = theHashTable.find(aKey);
					if(aDataItem != null)
					{
						System.out.println("Found " + aKey);
					}
					else
						System.out.println("Could not find " + aKey);
					break;
				default:
					System.out.print("Invalid entry\n");
			}  // end switch
		}  // end while
	}  // end main()
	//--------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	//--------------------------------------------------------------
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
//--------------------------------------------------------------
}  // end class HashTableApp
////////////////////////////////////////////////////////////////


public class Hash {

}
