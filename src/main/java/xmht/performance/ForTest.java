package xmht.performance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengjk1
 * @date 2019-07-08
 */
/*
for-each,两种fori 性能测试

fori  本质上完全是数组操作
for-each 在万级别的，性能明显下降，越往后下降的越厉害
for-each 的本质是迭代器，iterator.remove是不会 fast-fail的，集合在 iterator 的时候，本身的的任何改变都会导致 fast-fail,因为 modCount != expectedModCount
for(Iterator var12 = list.iterator(); var12.hasNext(); var13 = (String)var12.next()) {
}
 */
public class ForTest {
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			list.add("a"+i);
		}
		
		for (int j = 0; j < 10; j++) {
			long begin = System.currentTimeMillis();
//			for (int i = 0; i < 100000000; i++) {
				for (int i1 = 0; i1 < list.size(); i1++) {
				}
//			}
			long end = System.currentTimeMillis();
			System.out.println("list.size()"+(end-begin));

			begin = System.currentTimeMillis();
//			for (int i = 0; i < 100000000; i++) {
				for (int i1 = 0,n=list.size(); i1 < n; i1++) {
				}
//			}
			end = System.currentTimeMillis();
			System.out.println("n"+(end-begin));

			begin = System.currentTimeMillis();

//			for (int i = 0; i < 100000000; i++) {
				for (String s : list) {
				}
//			}
			end = System.currentTimeMillis();
			System.out.println("forearch"+(end-begin));
			System.out.println("==========");
		}
		
	}
}
