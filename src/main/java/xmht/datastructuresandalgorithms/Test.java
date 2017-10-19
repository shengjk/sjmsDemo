package xmht.datastructuresandalgorithms;

/**
 * Created by shengjk1 on 2017/9/6.
 */
public class Test {
	
	public static void ForMeoth(int n){
		long startTIme=System.currentTimeMillis();
		for (int i = 0; i < n; i--) {
			System.out.println(i);
		}
		long endTIme=System.currentTimeMillis();
		System.out.println((endTIme-startTIme)/1000.0/60 +"min");
	}
	
	public static void IterMeoth(int n){
		long startTIme=System.currentTimeMillis();
		if (n>=0){
			n--;
			IterMeoth(n);
			System.out.println(n);
		}
		long endTIme=System.currentTimeMillis();
		System.out.println((endTIme-startTIme)/1000.0/60 +"min");
	}
	
	public static void main(String[] args) {
		long startTIme=System.currentTimeMillis();
		IterMeoth(1000);
		long endTIme=System.currentTimeMillis();
		System.out.println((endTIme-startTIme)/1000.0/60 +"min");
	}
}
