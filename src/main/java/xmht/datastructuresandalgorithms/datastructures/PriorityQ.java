package xmht.datastructuresandalgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/15 0015
 */

//优先级队列，队头的优先级是最高的
//优先级队列，插入慢，删除快，在数据量较少，或者不太关心速度的情况下，
	//用数组实现的优先级队列还是可以满足的
	//插入操作O(N),删除O(1)
public class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	public PriorityQ(int s) {
		this.maxSize = s;
		queArray=new long[maxSize];
		nItems=0;
	}
	
	public void insert(long item){
		int j;
		if (nItems==0){
			queArray[nItems++]=item;
		}else {
			for (j=nItems-1;j>=0;j--){
				if (item>queArray[j]){
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
	
}
