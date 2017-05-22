package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */
public class ObjectSort {
}

class Person {
	private String lastName;
	private String firstName;
	private int age;
	
	public Person(String lastName, String firstName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	
	public void displayPerson() {
		System.out.println("last name " + lastName);
		System.out.println("first name " + firstName);
		System.out.println("age " + age);
	}
	
	public String getLastName() {
		return lastName;
	}
}

class ArrayInOb {
	private Person[] a;
	private int nElems;
	
	public ArrayInOb(int max) {
		a = new Person[max];
		nElems = 0;
	}
	
	public void insert(String last, String first, int age) {
		a[nElems] = new Person(last, first, age);
		nElems++;
	}
	
	public void insertionSort(){
		int in,out;
		for (out = 0; out < nElems; out++) {
			Person temp=a[out];
			in=out;
			while (in>0 && a[in-1].getLastName().compareTo(temp.getLastName())>0){
				a[in]=a[in-1];
				--in;
			}
			a[in]=temp;
		}
	}
	
}