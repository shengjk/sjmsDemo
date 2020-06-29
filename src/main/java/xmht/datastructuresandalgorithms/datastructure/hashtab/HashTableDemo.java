package xmht.datastructuresandalgorithms.datastructure.hashtab;

import java.util.Objects;

/**
 * @author shengjk1
 * @date 2020/5/9
 */
public class HashTableDemo {
	public static void main(String[] args) {
	
	}
}

class Emp {
	public int id;
	public String name;
	public Emp next;
	
	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Emp emp = (Emp) o;
		return id == emp.id &&
				Objects.equals(name, emp.name) &&
				Objects.equals(next, emp.next);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, next);
	}
	
	@Override
	public String toString() {
		return "Emp{" +
				"id=" + id +
				", name='" + name + '\'' +
				", next=" + next +
				'}';
	}
}

class EmpLinkedList {
	private Emp head;
	
	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		//如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
		Emp curEmp = head;
		
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
		curEmp.next = emp;
	}
	
	//遍历链表的雇员信息
	public void list(int no) {
		if (head == null) {
			return;
		}
		
		Emp curEmp = head;
		while (true) {
			System.out.println(curEmp);
			
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}
	}
}
