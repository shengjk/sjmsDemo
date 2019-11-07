package xmht.datastructuresandalgorithms;

/**
 * @author shengjk1
 * @date 2019-06-15
 */
public class NetherlandsFlag {
	
	public static void partition(int[] arr,int L,int R, int num){
		int less=L-1;
		int more=R+1;
		int cur=L;
		//for循环解决不了的问题，可以试试 while , do while
		while (cur<more){
			if (arr[cur]<num){
				swap(arr,++less,cur++);
			}else if (arr[cur]>num){
				//不知道交换之后是大是小
				swap(arr,--more,cur);
			}else{
				cur++;
			}
		}
//		return new int[]{less+1,more-1};
	}
	
	public static void swap(int[] arr,int i,int j){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
