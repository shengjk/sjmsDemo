package xmht.javabase.xuliehua;

import java.io.*;

/**
 * Created by shengjk1 on 2018/4/24
 */

/*
复杂的序列化，例如某一部分不进行序列化
对于Serializable对象，对象完全以它存储二进制位基础来构造，而不调用构造器。
对于Externalizable对象，所有普通的默认狗在其都会被调用，包括在字段定义时的初始化
注意的是，所有的默认构造器都会被调用，才能是Externalizable对象产生正确的行为

由于Externalizabled对象在默认情况下不保存它们任何字段，所有transient关键字只能和Serializable对象一起使用
 */

class Blip1 implements Externalizable{
	public Blip1() {
		System.out.println("Blip1 default constructor");
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1 writeExternal");
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1 readExternal");
	}
}

class Blip2 implements Externalizable{
	 Blip2() {
		System.out.println("Blip2 default constructor");
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2 writeExternal");
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2 readExternal");
	}
}


public class Blips {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Blip1 b1=new Blip1();
		Blip2 b2=new Blip2();
		
		ObjectOutputStream o =new ObjectOutputStream(new FileOutputStream("Blips.out"));
		System.out.println("saving objects:");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		
		ObjectInputStream in =new ObjectInputStream(new FileInputStream("Blips.out"));
		System.out.println("Recovering b1:");
		b1=(Blip1)in.readObject();
	}
}
