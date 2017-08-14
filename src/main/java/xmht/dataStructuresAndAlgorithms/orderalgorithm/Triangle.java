package xmht.dataStructuresAndAlgorithms.orderalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by shengjk1 on 2017/6/22.
 */
class TriangleApp{
	static int theNumber;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
		theNumber=getInt();
		int theAnswer=triangle(theNumber);
		System.out.println(theAnswer);
	}
	
	public static int triangle(int n){
		if(n==1){
			return 1;
		}else {
			return n+triangle(n-1);
		}
	}
	
	public static String getString() throws IOException {
		InputStreamReader irs=new InputStreamReader(System.in);
		BufferedReader br =new BufferedReader(irs);
		String s =br.readLine();
		return s;
	}
	
	public static int getInt() throws IOException {
		String s=getString();
		return Integer.parseInt(s);
	}
}


public class Triangle {

}
