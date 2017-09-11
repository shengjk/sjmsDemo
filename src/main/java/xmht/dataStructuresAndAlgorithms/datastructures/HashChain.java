package xmht.dataStructuresAndAlgorithms.datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shengjk1 on 2017/9/11
 */

class Link3{
	private int iData;
	public Link3 next;
	
	public Link3(int iData) {
		this.iData = iData;
	}
	
	public int getKey(){
		return iData;
	}
	
	public void displayLink(){
		System.out.println(iData+" ");
	}
}

class SortedList3{
	private Link3 first;
	
	public void SortedList(){
		first=null;
	}
	
	public void insert(Link3 theLink){
		int key=theLink.getKey();
		Link3 previous=null;
		Link3 current=first;
		
		while (current!=null && key>current.getKey()){
			previous=current;
			current=current.next;
		}
		if (previous==null){
			first=theLink;
		}else {
			previous.next=theLink;
		}
		theLink.next=current;
	}
	
	public void delete(int key){
		Link3 previous=null;
		Link3 current=first;
		
		while (current!=null && key!=current.getKey()){
			previous=current;
			current=current.next;
		}
		
		if (previous==null){
			first=first.next;
		}else {
			previous.next=current.next;
		}
	}
	
	public Link3 find(int key){
		Link3 current=first;
		
		while (current!=null && current.getKey()<=key){
			if (current.getKey()==key){
				return current;
			}
			current=current.next;
		}
		return null;
	}
	
	public void displayList(){
		System.out.println("list (first -> last): ");
		Link3 current=first;
		while (current!=null){
			current.displayLink();
			current=current.next;
		}
		System.out.println("");
	}
}

class HashTable3{
	private SortedList3[] hashArray;
	private int arraySize;
	
	public HashTable3(int size){
		arraySize=size;
		hashArray=new SortedList3[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			hashArray[i]=new SortedList3();
		}
	}
	
	public void displayTable(){
		for (int i = 0; i < arraySize; i++) {
			System.out.println(i + ". ");
			hashArray[i].displayList();
		}
	}
	
	public int hashFunc(int key){
		return key%arraySize;
	}
	
	public void insert(Link3 theLink){
		int key=theLink.getKey();
		int hashVal=hashFunc(key);
		hashArray[hashVal].insert(theLink);
	}
	
	public void delete(int key){
		int hasVal=hashFunc(key);
		hashArray[hasVal].delete(key);
	}
	
	public Link3 find(int key){
		int hasVal=hashFunc(key);
		Link3 theLink=hashArray[hasVal].find(key);
		return theLink;
	}
}


class HashChainApp
{
	public static void main(String[] args) throws IOException
	{
		int aKey;
		Link3 aDataItem;
		int size, n, keysPerCell = 100;
		// get sizes
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		// make table
		HashTable3 theHashTable = new HashTable3(size);
		
		for(int j=0; j<n; j++)         // insert data
		{
			aKey = (int)(java.lang.Math.random() *
					keysPerCell * size);
			aDataItem = new Link3(aKey);
			theHashTable.insert(aDataItem);
		}
		while(true)                    // interact with user
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
					aDataItem = new Link3(aKey);
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
						System.out.println("Found " + aKey);
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
//--------------------------------------------------------------
}  // end class HashChainApp
////////////////////////////////////////////////////////////////

public class HashChain {
}
