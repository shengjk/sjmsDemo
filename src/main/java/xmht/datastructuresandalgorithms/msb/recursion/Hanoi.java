package xmht.datastructuresandalgorithms.msb.recursion;

/**
 * @author shengjk1
 * @date 2021/3/3
 */
public class Hanoi {

	public static void hanoi2(int n) {
		if (n > 0) {
			func(n, "from", "to", "other");
		}
	}

	/*
	n 层汉罗塔问题 from to other
	n 层 from ---> to
	1. n-1 from --->other
	2. n  from ---> to
	3. 剩下的n-1 other ----> from
	 */
	public static void func(int n, String from, String to, String other) {
		if (n == 1) {
			System.out.println("move 1 from:" + from + " to:" + to + " other:" + other);
		}
		func(n - 1, from, other, to);
		System.out.println(" move " + n + " from:" + from + " to:" + to + " other:" + other);
		func(n - 1, other, to, from);
	}

}
