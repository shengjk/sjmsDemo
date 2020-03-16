package xmht.arts.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author shengjk1
 * @date 2020/3/14
 */
public class TestEquals {
	public static void main(String[] args) {
		HashMap<Student, String> map = new HashMap<>();
		Student student = new Student(16, "小明");
		map.put(student, "a");
		Student student1 = new Student(16, "小明");
		System.out.println("map " + map.containsKey(student1));
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(student);
		System.out.println("list " + students.contains(student1));
	}
}

class Student {
	private int age;
	private String name;
	
	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return age == student.age &&
				Objects.equals(name, student.name);
	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(age, name);
//	}
}