package xmht.zsda.handwriting.four;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author shengjk1
 * @date 2020/10/6
 */
public class Heap02 {
	
	public static class MyHeap<T> {
		private ArrayList<T> heap;
		private HashMap<T, Integer> indexMap;
		private int heapSize;
		private Comparator<? super T> comparator;
		
		public MyHeap(Comparator<? super T> comparator) {
			this.comparator = comparator;
			heap = new ArrayList<>();
			indexMap = new HashMap<>();
			heapSize = 0;
			this.comparator = comparator;
		}
		
		public boolean isEmpty() {
			return heapSize == 0;
		}
		
		public boolean consains(T key) {
			return indexMap.containsKey(key);
		}
		
		public void push(T value) {
			heap.add(value);
			indexMap.put(value, heapSize);
			heapInsert(heapSize++);
		}
		
		public T pop() {
			T ans = heap.get(0);
			int end = heapSize - 1;
			swap(0, end);
			heap.remove(0);
			indexMap.remove(ans);
			heapify(0, --heapSize);
			return ans;
		}
		
		public void resign(T value) {
			int valueIndex = indexMap.get(value);
			heapInsert(valueIndex);
			heapify(valueIndex, heapSize);
		}
		
		//上扬
		public void heapInsert(int index) {
			while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
				swap(index, (index - 1) / 2);
				index = (index - 1) / 2;
			}
		}
		
		//下沉
		public void heapify(int index, int more) {
			int left = 2 * index + 1;
			while (left < more) {
				int largetIndex = left + 1 < more && comparator.compare(heap.get(left), heap.get(left + 1)) < 0 ? left + 1 : left;
				largetIndex = comparator.compare(heap.get(largetIndex), heap.get(index)) < 0 ? largetIndex : index;
				
				if (largetIndex == index) {
					break;
				}
				swap(largetIndex, index);
				index = largetIndex;
				left = 2 * index + 1;
			}
		}
		
		private void swap(int i, int j) {
			T o1 = heap.get(i);
			T o2 = heap.get(j);
			heap.set(i, o2);
			heap.set(j, o1);
			indexMap.put(o1, j);
			indexMap.put(o2, i);
		}
		
	}
}
