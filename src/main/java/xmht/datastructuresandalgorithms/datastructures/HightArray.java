package xmht.datastructuresandalgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/12 0012
 */

/**
 * Object-oriented's Array
 */
class HighArray {
	private long[] a;
	//array's length
	private int nElems;
	
	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}
	
	
	/**
	 * search key
	 *
	 * @param searchKey
	 * @return
	 */
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] == searchKey) {
				break;
			}
		}
		if (j == nElems) {
			return false;
		} else {
			return true;
		}
	}
	
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
	
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++) {
			if (value == a[j]) {
				break;
			}
		}
		if (j == nElems) {
			return false;
		} else {
			for (int k = j; k < nElems; k++) {
				a[k] = a[k + 1];
			}
			nElems--;
			return true;
		}
	}
	
	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.println(a[j] + " ");
		}
	}
	
}

class HightArrayApp {
	public static void main(String[] args) {
		int maxSize = 100;
		HighArray arr = new HighArray(maxSize);
		
		arr.insert(77);
		arr.insert(99);
		arr.insert(66);
		
		arr.display();
		System.out.println(arr.delete(99));
		arr.display();
		
	}
}



