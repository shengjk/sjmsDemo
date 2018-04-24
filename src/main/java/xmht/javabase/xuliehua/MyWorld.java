package xmht.javabase.xuliehua;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjk1 on 2018/4/24
 */

class House implements Serializable {
}

class Animal implements Serializable {
	private String name;
	private House preferredHouse;
	
	public Animal(String name, House preferredHouse) {
		this.name = name;
		this.preferredHouse = preferredHouse;
	}
	
	@Override
	public String toString() {
		return name + "[" + super.toString() + "]," + preferredHouse + "\n";
	}
}

public class MyWorld {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("aosco the dog", house));
		animals.add(new Animal("RaIph the hamster", house));
		animals.add(new Animal("H011y the cat", house));
		System.out.println("animals= " + animals);
		
		ByteArrayOutputStream bufl = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(bufl);
		o1.writeObject(animals);
		o1.writeObject(animals);
		o1.close();
		
		// Write to a different stream:
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream o2 = new ObjectOutputStream(buf2);
		o2.writeObject(animals);
		o2.writeObject(animals);
		o2.close();
		
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(bufl.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
	
		List animals1=(List)in1.readObject();
		List animals2=(List)in1.readObject();
		List animals3=(List)in2.readObject();
		List animals4=(List)in2.readObject();
		
		System.out.println("animals1= "+animals1);
		System.out.println("animals2= "+animals2);
		System.out.println("animals3= "+animals3);
		System.out.println("animals4= "+animals4);
		
		
		
		/*
		animals= [aosco the dog[xmht.javabase.xuliehua.Animal@4b1210ee],xmht.javabase.xuliehua.House@4d7e1886
, RaIph the hamster[xmht.javabase.xuliehua.Animal@3cd1a2f1],xmht.javabase.xuliehua.House@4d7e1886
, H011y the cat[xmht.javabase.xuliehua.Animal@2f0e140b],xmht.javabase.xuliehua.House@4d7e1886
]
animals1= [aosco the dog[xmht.javabase.xuliehua.Animal@17a7cec2],xmht.javabase.xuliehua.House@65b3120a
, RaIph the hamster[xmht.javabase.xuliehua.Animal@6f539caf],xmht.javabase.xuliehua.House@65b3120a
, H011y the cat[xmht.javabase.xuliehua.Animal@79fc0f2f],xmht.javabase.xuliehua.House@65b3120a
]
animals2= [aosco the dog[xmht.javabase.xuliehua.Animal@17a7cec2],xmht.javabase.xuliehua.House@65b3120a
, RaIph the hamster[xmht.javabase.xuliehua.Animal@6f539caf],xmht.javabase.xuliehua.House@65b3120a
, H011y the cat[xmht.javabase.xuliehua.Animal@79fc0f2f],xmht.javabase.xuliehua.House@65b3120a
]
animals3= [aosco the dog[xmht.javabase.xuliehua.Animal@50040f0c],xmht.javabase.xuliehua.House@2dda6444
, RaIph the hamster[xmht.javabase.xuliehua.Animal@5e9f23b4],xmht.javabase.xuliehua.House@2dda6444
, H011y the cat[xmht.javabase.xuliehua.Animal@4783da3f],xmht.javabase.xuliehua.House@2dda6444
]
animals4= [aosco the dog[xmht.javabase.xuliehua.Animal@50040f0c],xmht.javabase.xuliehua.House@2dda6444
, RaIph the hamster[xmht.javabase.xuliehua.Animal@5e9f23b4],xmht.javabase.xuliehua.House@2dda6444
, H011y the cat[xmht.javabase.xuliehua.Animal@4783da3f],xmht.javabase.xuliehua.House@2dda6444
]

		 */
	}
}
