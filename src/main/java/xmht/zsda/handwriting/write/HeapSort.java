package xmht.zsda.handwriting.write;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author shengjk1
 * @date 2020/11/23
 */
/*
需要再记

用数组表示 堆
头 n-1/2
左子树 2 *n+1
右子树 2 *n+2

 */
public class HeapSort {
	
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		
		//变为大根堆，优化
//		for (int i = arr.length - 1; i >= 0; i--) {
//			heapify(arr, i, arr.length);
//		}
		int heapSize = arr.length;
		// O(N*logN)
		while (heapSize > 0) { // O(N)
			heapify(arr, 0, heapSize); // O(logN)
			swap(arr, 0, --heapSize); // O(1)
		}
	}
	
	//堆排序，实际上是利用 heapify,针对每一个数据，不断的调用 heapify
	//根据每个 index 对应的值,先找到最大的 largest index，然后将 index 与 largest 进行交换了
	//如果最大的 index ==index 就 break;
	public static void heapify(int[] arr, int index, int heapsize) {
		int left = 2 * index + 1;
		while (left < heapsize) {
			//左子节点 和 右子节点，两者中的较大者。因为是 int[] 所以不会有为 null 的情况
			int largest = left + 1 < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
			//跟头结点比较大小，去较大的 index
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}
	
	//大顶堆，新插入的节点如果比头结点大，则交换
	public static void heapInsert(int[] arr, int index) {
		//新添加位置的索引比头结点大，就把它与头结点交换，一直交换到，不大于头结点位置
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
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
	
