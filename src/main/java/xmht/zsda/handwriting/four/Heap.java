package xmht.zsda.handwriting.four;

/**
 * @author shengjk1
 * @date 2020/10/5
 */

/**
 * 用数组实现heap
 */
public class Heap {
	private int[] arr;
	private int heapSize = 0;
	
	public Heap(int arrLength) {
		this.arr = new int[arrLength];
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(5);
		heap.push(0);
		heap.push(1);
		heap.push(2);
		heap.push(3);
		heap.push(4);
		
		heap.disPlay();
		
		System.out.println(-1 / 2);
	}
	
	// logN 上升
	public void push(int element) {
		if (heapSize >= arr.length) {
			return;
		}
		arr[heapSize] = element;
		int curIndex = heapSize;
		heapSize++;
		while (curIndex >= 0) {
			//父节点与新加入节点比较大小
			if (arr[(curIndex - 1) / 2] >= arr[curIndex]) {
				break;
			} else {
				int tmp = arr[(curIndex - 1) / 2];
				arr[(curIndex - 1) / 2] = arr[curIndex];
				arr[curIndex] = tmp;
				
				curIndex = (curIndex - 1) / 2;
			}
		}
	}
	
	
	public int pop() {
		int ans = arr[0];
		int tmp = arr[--heapSize];
		arr[heapSize] = arr[0];
		arr[0] = ans;
		heapify(arr, 0, heapSize);
		return ans;
	}
	
	//下沉
	public void heapify(int[] arr, int index, int heapSize) {
		int left = 2 * index + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left] >= arr[left + 1] ? left : left + 1;
			
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			// 下沉了
			int tmp = arr[index];
			arr[index] = arr[largest];
			arr[largest] = tmp;
			
			index = largest;
			left = 2 * index + 1;
		}
	}
	
	public void disPlay() {
		for (int i : arr) {
			System.out.println(i);
		}
		System.out.println("heapSize = " + heapSize);
	}
}
