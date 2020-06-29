package xmht.datastructuresandalgorithms.datastructure.tree;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/5/31
 */
public class HeapSort {
	public static void main(String[] args) {
		//将数组进行升序排列
		int arr[] = {4, 6, 8, 5, 9};
		heapSort(arr);
	}
	
	//
	public static void heapSort(int[] arr) {
		
		int temp = 0;
		//1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或者小顶堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adJustHeap(arr, i, arr.length);
		}
		/*
		2.将堆顶元素与末尾元素交换，将最大元素沉到数组末端
		3.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前数组的末尾元素
		反复执行 调整交换，直到整个序列有序ßß
		 */
		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adJustHeap(arr, 0, j);
		}
		
		System.out.println("result:" + Arrays.toString(arr));
	}
	
	
	//将一个数组(二叉树)，调整成一个大顶堆
	
	/**
	 * @param arr
	 * @param i      表示非叶子节点在数组中的索引
	 * @param length 对多少个元素进行调整
	 */
	public static void adJustHeap(int arr[], int i, int length) {
		int temp = arr[i];
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			//说明左子节点的大小小于右子节点
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				//指向右子节点
				k++;
			}
			//k 子节点中值较大者
			//如果子节点大于父节点，则进行交换
			if (arr[k] > temp) {
				arr[i] = arr[k];
				//调整子树的父节点，导致子树不满足大堆，所以要继续循环
				//
				i = k;
			} else {
				break;
			}
		}
		//
		arr[i] = temp;
	}
}
