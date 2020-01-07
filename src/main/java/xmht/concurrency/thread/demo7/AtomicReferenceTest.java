package xmht.concurrency.thread.demo7;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author shengjk1
 * @date 2020/1/7
 */
public class AtomicReferenceTest {
	public static AtomicReference<User> userAtomicReference = new AtomicReference<>();
	
	public static void main(String[] args) {
		User user = new User("conan", 15);
		userAtomicReference.set(user);
		User updatedUser = new User("Shinichi", 17);
		userAtomicReference.compareAndSet(user, updatedUser);
		System.out.println(userAtomicReference.get().getName());
		System.out.println(userAtomicReference.get().getOld());
	}
	
	static class User {
		private String name;
		private int old;
		
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
}
