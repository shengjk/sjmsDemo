package xmht.DataStructuresAndAlgorithms;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
//O(n^2) 相对于冒泡排序更快些，因为它进行的交换少得多。当N值较少时，特别的是如果交换的时间比比较的时间大得多时，选择排序实际上相当快
public class SelectSort {
    public static void main(String[] args) {
        int[] a ={1,10,2,30,4,50,2,0,-1};
        int length=a.length;
        int min;
        for (int out = 0; out < length-1; out++) {
            min=out;
            for (int in = out+1; in <length ; in++) {
                if(a[in]<a[min]){
                    min=in;
                }
            }
            //交换n次
            int temp=a[out];
            a[out]=a[min];
            a[min]=temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        
    }
}
