package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */
//优先级队列，没有指针环绕
	//插入时间是O(N),删除O(1)
public class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	public PriorityQ(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}
	
	public void insert(long item) {
		int j;
		if (nItems == 0) {
			queArray[nItems++] = item;
		}else {
			for(j=nItems-1;j>=0;j--){
				if(item>queArray[j]){
					queArray[j+1]=queArray[j];
				}else {
					break;
				}
			}
			queArray[j+1]=item;
			nItems++;
		}
	}
	
	public long remove(){
		return queArray[--nItems];
	}
	
	public long peekMin(){
		return queArray[nItems-1];
	}
	public boolean isEmpty(){
		return nItems==0;
	}
	public boolean isFull(){
		return nItems==maxSize;
	}
}
class PriorityQApp{
	public static void main(String[] args) {
		PriorityQ priorityQ=new PriorityQ(5);
		priorityQ.insert(20);
		priorityQ.insert(230);
		priorityQ.insert(210);
		priorityQ.insert(21);
		priorityQ.insert(0);
		
		while (!priorityQ.isEmpty()){
			long item=priorityQ.remove();
			System.out.println(item+" ");
		}
		
	}
}
