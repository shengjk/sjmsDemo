package xmht.datastructuresandalgorithms.datastructure;

/**
 * @author shengjk1
 * @date 2020/1/4
 */
public class SparseArray {
	public static void main(String[] args) {
		/*
		二维数组 to 稀疏数组，本质上是时间换空间，如果数组很大，整个转换的过程是很慢的，具体的算法需要优化
		 */
		
		String [][]a={
				{"1","0","0","0","0","0","0","0"},
				{"0","0","0","0","0","0","0","1"}
		};
		
		int lines=a.length;
		int columns=a[0].length;
		System.out.println(a.length +" "+a[0].length);
		
		int sparseSumLines=0;
		for (String[] strings : a) {
			for (String string : strings) {
				if (!string.equals("0")){
					sparseSumLines++;
				}
			}
		}
		sparseSumLines++;
		System.out.println("sparseSumLines=== "+sparseSumLines);
		int[][] sparseArray = new int[sparseSumLines][sparseSumLines];
		sparseArray[0][0]=lines;
		sparseArray[0][1]=columns;
		sparseArray[0][2]=sparseSumLines;
		
		int sparseLines=1;
		for (int i=0;i<a.length;i++){
			for (int j = 0; j < a[0].length; j++) {
				if (!a[i][j].equals("0")) {
					sparseArray[sparseLines][0]=i;
					sparseArray[sparseLines][1]=j;
					sparseArray[sparseLines][2]=Integer.valueOf(a[i][j]);
					sparseLines++;
				}
			}
		}
		
		for (int i = 0; i < sparseArray.length; i++) {
			for (int j = 0; j < sparseArray[0].length; j++) {
				System.out.print(sparseArray[i][j] +",");
			}
			System.out.println();
		}
		
		// 稀疏数组 to 二维数组
		
	}
}
