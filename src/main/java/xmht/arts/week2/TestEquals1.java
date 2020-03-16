package xmht.arts.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author shengjk1
 * @date 2020/3/14
 */
public class TestEquals1 {
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

class CaseInsensitiveString {
	private final String s;
	
	public CaseInsensitiveString(String s) {
		if (s == null) {
			throw new NullPointerException();
		}
		this.s = s;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CaseInsensitiveString that = (CaseInsensitiveString) o;
		return Objects.equals(s, that.s);
	}
}
