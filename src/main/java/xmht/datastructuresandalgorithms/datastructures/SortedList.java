package xmht.datastructuresandalgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/19 0019
 */

/**
 * 插入和删除 O(N),但是O(1)可以找到或者删除最小值(最优值)
 */
class SortedList {
	private Link2 first;
	
	public SortedList() {
	}
	
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insert(long key){
		Link2 newLinke=new Link2(key);
		Link2 previous=null;
		Link2 current=first;
		
		while (current!=null && key>current.dData){
			previous=current;
			current=current.next;
		}
		
		if(previous==null){
			first=newLinke;
		}else {
			previous.next=newLinke;
		}
		newLinke.next=current;
	}
	
	public Link2 remove(){
		Link2 temp =first;
		first=first.next;
		return temp;
	}
	
	public void displayList(){
		Link2 current=first;
		while (current!=null){
			current.displayLink();
			current=current.next;
		}
	}
}
class SortedListApp{
	public static void main(String[] args) {
		SortedList sortedList=new SortedList();
		sortedList.insert(20);
		sortedList.insert(204);
		sortedList.insert(202);
		sortedList.insert(201);
		sortedList.insert(200);
		sortedList.insert(2000);
		
		sortedList.displayList();
		
		sortedList.remove();
	}
}