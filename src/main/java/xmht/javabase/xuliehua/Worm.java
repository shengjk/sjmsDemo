package xmht.javabase.xuliehua;

import java.io.*;
import java.util.Random;

/**
 * Created by shengjk1 on 2018/4/24
 */

class Data implements Serializable{
	private static final long serialVersionUID = 5535820220048127239L;
	private int n;
	
	public Data(int n) {
		this.n = n;
	}
	
	@Override
	public String toString() {
		return Integer.toString(n);
	}
}

public class Worm implements Serializable {
	private static Random random=new Random(47);
	private Data[] d={
			new Data(random.nextInt(10)),
			new Data(random.nextInt(10)),
			new Data(random.nextInt(10))
	};
	private Worm next;
	private char c;
	
	public Worm(int i,char x) {
		System.out.println("Worm constructor: "+i);
		c=x;
		if (--i>0){
			next=new Worm(i,(char)(x+1));
		}
	}
	
	public Worm() {
		System.out.println("Defaultconstructor");
	}
	
	@Override
	public String toString() {
		StringBuilder result=new StringBuilder(";");
		result.append(c);
		result.append("(");
		for (Data dat:d){
			result.append(dat);
		}
		result.append(")");
		if (next!=null){
			result.append(next);
		}
		return result.toString();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Worm worm=new Worm(6,'a');
		System.out.println("w= "+worm);
		
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("worm.out"));
		out.writeObject("Worm storage\n");
		out.writeObject(worm);
		out.flush();
		out.close();
		
		
		//要想进行反序列化，首先JVM必须能找到相应的Class文件
		ObjectInputStream in =new ObjectInputStream(new FileInputStream("worm.out"));
		String s =(String)in.readObject();//把其中的string转化为string
		System.out.println("s2= "+s);
		Worm worm2=(Worm)in.readObject();//把其中的object转化为object
		System.out.println("w2= "+worm2);
		
		
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		ObjectOutputStream out2=new ObjectOutputStream(bout);
		out2.writeObject("Worm storage\n");
		out2.writeObject(worm);
		out2.flush();
		out2.close();
		
		
		
		ObjectInputStream in2 =new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		s=(String)in2.readObject();
		System.out.println("s3= "+s);
		Worm worm3=(Worm)in2.readObject();
		System.out.println("w3= "+worm3);
	}
}

