package xmht.javabase;

public class Client {
    /*
    count++是一个表达式，是有返回值的，它的返回值就是count自加前的值，Java对自加是这样处理的：首先把count的值（注意是值，不是引用）拷贝到一个临时变量区，然后对count变量加1，最后返回临时变量区的值。程序第一次循环时的详细处理步骤如下：
步骤1　JVM把count值（其值是0）拷贝到临时变量区。
步骤2　count值加1，这时候count的值是1。
步骤3　返回临时变量区的值，注意这个值是0，没修改过。
步骤4　返回值赋值给count，此时count值被重置成0。
     */
    
	public static void main(String[] args) {
            int count =0;  
            for(int i=0;i<10;i++){  
             count=count++;
            }  
            System.out.println("count="+count);  
     }  
} 