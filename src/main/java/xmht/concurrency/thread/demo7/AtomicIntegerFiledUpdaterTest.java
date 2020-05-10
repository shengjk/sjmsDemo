package xmht.concurrency.thread.demo7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author shengjk1
 * @date 2020/1/7
 */
/*
被更新的字段必须使用 public volatile 修饰符
 */
public class AtomicIntegerFiledUpdaterTest {
	private static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");
	
	public static void main(String[] args) {
		User conan = new User("conan", 10);
		System.out.println(a.getAndIncrement(conan));
		System.out.println(a.get(conan));
	}
}

class User {
	public volatile int old;
	private String name;
	
	public User(String name, int old) {
		this.name = name;
		this.old = old;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getOld() {
		return old;
	}
	
	public void setOld(int old) {
		this.old = old;
	}
}
