package xmht.javabase.xuliehua;

import java.io.*;

/**
 * Created by shengjk1 on 2018/4/24
 */
public class Blip3 implements Externalizable {
	private int i;
	private String s;
	
	public Blip3() {
		System.out.println("Blip3 constructor");
	}
	
	public Blip3(int i, String s) {
		System.out.println("Blip3(int i, String s) constructor");
		this.i = i;
		this.s = s;
	}
	
	@Override
	public String toString() {
		return s + i;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip3 writeExternal");
		out.writeObject(s);
		out.writeInt(i);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip3 readExternal");
		s = (String) in.readObject();
		i = in.readInt();
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Blip3 blip3 = new Blip3(47, "A String");
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
		o.writeObject(blip3);
		o.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
		blip3 = (Blip3) in.readObject();
		System.out.println(blip3);
	}
}
