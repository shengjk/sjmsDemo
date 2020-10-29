package xmht.zsda.handwriting.one;

/**
 * @author shengjk1
 * @date 2020/10/20
 */
//异或 无进位相加
// 0^N=N N^N=0
public class EvenTimesOddTimes {
	
	//arr 中，只有一种数，出现奇数次
	public static void printOddTimesNum1(int[] arr) {
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor = eor ^ arr[i];
		}
		System.out.println(eor);
	}
	
	// arr 中，有两种数，出现奇数次
	public static void printOddTimesNum2(int[] arr) {
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor = eor ^ arr[i];
		}
		
		// eor 必然有一个位置上是1
		int rightOne = eor ^ ((~eor) + 1);
		int onlyOne = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & rightOne) != 0) {
				onlyOne = onlyOne ^ arr[i];
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}
	
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.println(a);
		System.out.println(b);
		
		int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
		printOddTimesNum1(arr1);
		
		int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
		printOddTimesNum2(arr2);
		
	}
}

