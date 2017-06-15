package xmht.dataStructuresAndAlgorithms.datastructures;

/**
 * Binary Search's premise this Array was Ordered
 */

class OrdArray{
	private long[] a;
	private int nElems;
	
	public OrdArray(int max) {
		a=new long[max];
	}
	
	public int size(){
		return nElems;
	}
	
	//Binary Search
	public int find(long searchKey){
		int lowerBound=0;
		int upperBound=nElems-1;
		//center count
		int curIn;
		
		while (true){
			curIn=(lowerBound+upperBound)/2;
			if (a[curIn]==searchKey){
				return curIn;
			}else if (lowerBound>upperBound){
				return nElems;
			}else{
				if (a[curIn]<searchKey){
					lowerBound=curIn+1;
				}else {
					upperBound=curIn-1;
				}
			}
		}
	}
	
	public void insert(long value){
		int j;
		for (j=0;j<nElems;j++){
			if (a[j]<value){
				break;
			}
		}
		for (int k = nElems; k < j; k--) {
			a[k]=a[k-1];
		}
		a[j]=value;
		nElems++;
		
	
	}
	
}
