package xmht.zsda.handwriting;

/**
 * @author shengjk1
 * @date 2020/10/5
 */
public class QuickSort1 {
	
	//返回 lessEques
	public static int partition(int[] arr, int L, int R) {
		int lessEques = L - 1;
		int more = arr[R];
		int index = L;
		while (index <= R) {
			if (arr[index] >= more) {
				
				++lessEques;
				int tmp = arr[index];
				arr[index] = arr[lessEques];
				arr[lessEques] = tmp;
			}
			index++;
		}
		return lessEques;
	}
	
}
