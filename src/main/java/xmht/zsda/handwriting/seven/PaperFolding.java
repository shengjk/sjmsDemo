package xmht.zsda.handwriting.seven;

/**
 * @author shengjk1
 * @date 2020/10/27
 */
public class PaperFolding {
	public static void printAllFolds(int N) {
		printProcess(1, N, true);
	}
	
	//递归过程
	//i是节点的层数，N 一共多少层 down == true 凹 down == flase 凸
	public static void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.println(down ? "凹" : "凸");
		printProcess(i + 1, N, false);
	}
	
	public static void main(String[] args) {
		int N = 3;
		printAllFolds(N);
	}
}
