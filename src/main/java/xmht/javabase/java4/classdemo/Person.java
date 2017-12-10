package xmht.javabase.java4.classdemo;

/**
 * Created by shengjk1 on 2017/11/21
 */
public class Person extends Individual {
	public Person(String name){
		super(name);
	}
}

class Pet extends Individual{
	public Pet(String name) {
		super(name);
	}
	
	public Pet() {
		super();
	}
	
}

class Dog extends Pet{
	public Dog(String name) {
		super(name);
	}
	
	public Dog() {
		super();
	}
}

class Mutt extends Dog{
	public Mutt(String name) {
		super(name);
	}
	
	public Mutt() {
	}
}

class Cat extends Pet{
	public Cat(String name) {
		super(name);
	}
	
	public Cat() {
	}
}

class EgyptianMau extends Cat{
	public EgyptianMau(String name) {
		super(name);
	}
	
	public EgyptianMau() {
	}
}
