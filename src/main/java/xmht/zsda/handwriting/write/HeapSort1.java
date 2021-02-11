package xmht.zsda.handwriting.write;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author shengjk1
 * @date 2020/11/23
 */
public class HeapSort1 {
	//找到最大值，然后交换
	// 确定该值是否为最大值，如果不是交换，并且继续，如果是则停止
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = 2 * index + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = 2 * index + 1;
		}
	}
	
	
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	
	
	public static void heapSort(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		
		int headSize = arr.length;
		while (headSize > 0) {
			heapify(arr, 0, headSize);
			swap(arr, 0, --headSize);
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	
	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	
	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
	
	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// for test
	public static void main(String[] args) {
		
		// 默认小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		heap.add(6);
		heap.add(8);
		heap.add(0);
		heap.add(2);
		heap.add(9);
		heap.add(1);
		
		while (!heap.isEmpty()) {
			System.out.println(heap.poll());
		}
		
		int testTime = 50;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}
	
}

