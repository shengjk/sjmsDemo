package xmht.datastructuresandalgorithms.msb.window;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shengjk1
 * @date 2021/4/1
 */
// 单调栈 从栈底到栈顶，从小到大，可以针对重复数据
public class MonotonousStack {

	public static int[][] getNearLess(int[] arr) {
		int[][] res = new int[arr.length][2];

		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			//弹出，谁让它弹出的谁就是右边最近比它小的，它下面压着谁(list 最后的数)就是左边离它最近比它小的数
			while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
				List<Integer> pop = stack.pop();

				int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);

				for (int index : pop) {
					//左边最近比 index 小的
					res[index][0] = leftLessIndex;
					// 右边最近比 index 小的
					res[index][1] = i;
				}
			}

			//相等或大于
			if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
				stack.peek().add(i);
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				stack.push(list);
			}
		}
		//最后处理 stack 中剩余的数据
		while (!stack.isEmpty()) {
			List<Integer> pop = stack.pop();

			int leftLessIndex = stack.isEmpty() ? -1 : stack.peek().get(stack.peek().size() - 1);
			for (int index : pop) {
				res[index][0] = leftLessIndex;
				res[index][1] = -1;
			}
		}

		return res;
	}


	// for test
	public static int[] getRandomArrayNoRepeat(int size) {
		int[] arr = new int[(int) (Math.random() * size) + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < arr.length; i++) {
			int swapIndex = (int) (Math.random() * arr.length);
			int tmp = arr[swapIndex];
			arr[swapIndex] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}

	// for test
	public static int[] getRandomArray(int size, int max) {
		int[] arr = new int[(int) (Math.random() * size) + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
		}
		return arr;
	}

	// for test
	public static int[][] rightWay(int[] arr) {
		int[][] res = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++) {
			int leftLessIndex = -1;
			int rightLessIndex = -1;
			int cur = i - 1;
			while (cur >= 0) {
				if (arr[cur] < arr[i]) {
					leftLessIndex = cur;
					break;
				}
				cur--;
			}
			cur = i + 1;
			while (cur < arr.length) {
				if (arr[cur] < arr[i]) {
					rightLessIndex = cur;
					break;
				}
				cur++;
			}
			res[i][0] = leftLessIndex;
			res[i][1] = rightLessIndex;
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[][] res1, int[][] res2) {
		if (res1.length != res2.length) {
			return false;
		}
		for (int i = 0; i < res1.length; i++) {
			if (res1[i][0] != res2[i][0] || res1[i][1] != res2[i][1]) {
				return false;
			}
		}

		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int size = 10;
		int max = 20;
		int testTimes = 2000000;
		for (int i = 0; i < testTimes; i++) {
			int[] arr2 = getRandomArray(size, max);
			if (!isEqual(getNearLess(arr2), rightWay(arr2))) {
				System.out.println("Oops!");
				printArray(arr2);
				break;
			}
		}
		System.out.println("prefect===");
	}
}
