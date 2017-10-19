package xmht.datastructuresandalgorithms.datastructures;

/**
 * Created by shengjk1 on 2017/6/19 0019
 */

/**
 * 双端链表，头有直接指向尾的引用，redis内部就是使用了，双端列表，虽然不知道它有什么好处
 *
 * 查找时，链表肯定比数组慢，链表还要寻址。
 * 删除、插入，小数据量的情况下，数组不一定比链表慢，关键就是移动跟寻址那个时间会更长一些
 * 一般是查多用数组，插删多用链表。
 * 另外链表相对于数组来说，内存需要多少有多少，并且可以使不连续的，而数组，在
 * 创建时就固定了，所以经常由于数组太大导致效率低下或者数组太小空间溢出。
 *
 * 此处查、插、删，均值随机，还有数据量。
 * 查、插、删首位末尾，时间复杂度都是一样的
 */
class Link2 {
	public long dData;
	public Link2 next;
	
	public Link2(long d){
		dData=d;
	}
	
	public void displayLink(){
		System.out.println(dData +" ");
	}
}


class FirstLastList {
	private Link2 first;
	private Link2 last;
	
	FirstLastList(){
	
	}
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(long dd){
		Link2 newLink=new Link2(dd);
		
//		if(isEmpty()){
//			last=newLink;
//			first=newLink;
//		}else {
//			newLink.next=first;
//			first=newLink;
//		}
		if (isEmpty()){
			last=newLink;
		}
		newLink.next=first;
		first=newLink;
	}
	
	public void insertLast(long dd){
		Link2 newLinke=new Link2(dd);
		if (isEmpty()){
			first=newLinke;
		}else {
			last.next=newLinke;
		}
		last=newLinke;
	}
	
	public long deleteFirst(){
		long temp=first.dData;
		if(first.next==null){
			last=null;
		}
		first=first.next;
		return temp;
	}
	
	public Link2 delete(int key){
		Link2 current=first;
		Link2 previous=first;
		while (current.dData!=key){
			if (current.next==null){
				last=previous;
				return null;
			}else {
				previous=current;
				current=current.next;
			}
		}
		if (current==first){
			first=first.next;
		}else {
			previous.next=current.next;
		}
		return current;
	}
	
	public void displayList(){
		Link2 current=first;
		while (current!=null){
			current.displayLink();
			current=current.next;
		}
	}
}

class FirstLastApp{
	public static void main(String[] args) {
		FirstLastList firstLastList=new FirstLastList();
		firstLastList.insertFirst(22);
		firstLastList.insertFirst(224);
		firstLastList.insertFirst(226);
		firstLastList.insertFirst(228);
		firstLastList.insertFirst(220);
		
		firstLastList.insertLast(33);
		firstLastList.insertLast(334);
		firstLastList.insertLast(336);
		firstLastList.insertLast(338);
		
		firstLastList.displayList();
	}
}