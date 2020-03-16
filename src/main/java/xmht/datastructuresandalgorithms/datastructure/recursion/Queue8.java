package xmht.datastructuresandalgorithms.datastructure.recursion;

/**
 * @author shengjk1
 * @date 2020/3/4
 */
/*
8皇后问题，在 8 * 8 的棋盘上，任何两个皇后都不能处于同一行同一列或同一个斜线上。

1.第一个皇后先放第一行第一列
2.第二个皇后放在第二行第一列，然后判断是否ok，如果不 ok，继续放在第二列、第三列，依次把所有列都放完，找到一个合适的
3.继续第三个皇后，还是第一列、第二列......直到第8个皇后也能放在一个不冲突的位置，算是找到了一个正确的解。
4.当得到第一个正确解时，在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解全部找到。
5.然后回头继续第一个皇后放第二列，后面继续循环执行1234步骤。


理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题。arr[8]={0,1,2,3,4,5,6,7} 对应的 arr 下标
表示第几行，即第几个皇后，arr[i]=val,val表示第i+1个皇后，放在第i+1行的第val+1列。
 */
public class Queue8 {
	//定义一个有多少个皇后
	int max = 8;
	//定义数组 arrya,保存皇后存放位置的结果。
	int[] array = new int[max];
//	int[] array = {-1, -1, -1, -1, -1, -1, -1, -1};
	
	static int count = 0;
	
	public static void main(String[] args) {
		Queue8 queue8 = new Queue8();
		// 从第 0 行开始
		queue8.check(0);
		System.out.println(count);
	}
	
	
	//这一块会有递归会有回溯，其实还是挺巧妙的
	private void check(int n) {
		//相当于该放第 9 个皇后了
		if (n == max) {
			count++;
			print();
			return;
		}
		
		//依次放入皇后，并判断是否冲突
		//这个的max 其实是列数
		for (int i = 0; i < max; i++) {
			//先把皇后 n 放到该行的第一列
			array[n] = i;
			//判断当放置第 n 个皇后置第 i列时，是否与之前的n-1个皇后冲突
			if (judge(n)) {
				//不冲突，就接着放下一个皇后。
				check(n + 1);
			}
		}
	}
	
	
	/*
	 1.arrya[i]==arrya[n]表示判断第n个皇后是否与前面 n-1 个皇后在同一列
	 2.Math.abs(n - i) == Math.abs(array[n] - array[i])表示判断第 n 个皇后是否与第 i 个皇后在同一个斜线上。(列差等于行差，肯定在同一个斜线上)
	 3.没有必要判断是否在同一行
	 */
	private boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}
	
	//输出皇后的位置
	private void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
