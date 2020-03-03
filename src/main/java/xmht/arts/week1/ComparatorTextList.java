package xmht.arts.week1;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class ComparatorTextList {
	public static void main(String[] args) {
		List<User> userlist = new ArrayList<User>();
		User user1 = new User("Y - 易小星 ", 31);
		User user2 = new User("W - 王大锤", 33);
		userlist.add(user1);
		userlist.add(user2);
		//我要比较一系列的对象
		Comparator<User> cmp = new ComparatorUser();
		Collections.sort(userlist, cmp);
		for (User user : userlist) {
			System.out.println(user.getName());
		}
		
		System.out.println("hsahSet=====");
		HashSet<User> users = new HashSet<>();
		users.add(user1);
		users.add(user2);
		for (User user : users) {
			System.out.println(user.getName());
		}
		System.out.println("treeSet=====");
		//依据 Comparable 自然顺序排序
		TreeSet<User> treeSet = new TreeSet<>();
		treeSet.addAll(users);
		for (User user : treeSet) {
			System.out.println(user.getName());
		}
		
		//this 与相应的类对象进行比较
		System.out.println(user2.compareTo(user1));
	}
}

//也需要遵循 the general contract,建议实现 Serializable 接口
class ComparatorUser implements Comparator<User> {
	@Override
	public int compare(User u1, User u2) {
		// 先按年龄排序
		int flag = u1.getAge().compareTo(u2.getAge());
		// 年龄相等比较姓名
		if (flag == 0) {
			return u1.getName().compareTo(u2.getName());
		} else {
			return flag;
		}
	}
}


class User implements Comparable<User> {
	private String name;
	private Integer age;
	
	public User() {
		super();
	}
	
	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(@NotNull User user) {
		// 先按年龄排序
		int flag = this.age.compareTo(user.getAge());
		// 年龄相等比较姓名
		if (flag == 0) {
			return this.getName().compareTo(user.getName());
		} else {
			return flag;
		}
	}
	
	//最好是重写一下 equals 方法，防止两个类对象相同而 equals 不同，不满足 Object 的约束
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(name, user.name) &&
				Objects.equals(age, user.age);
	}
	
	//同理的，重写 equals 方法，一般都需要重写 hashCode 方法，这样才能保证，equals 相等的两个对象的 hashCode 也相同，
	// 满足 Object 约束
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}