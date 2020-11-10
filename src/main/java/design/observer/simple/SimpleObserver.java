package design.observer.simple;

import java.util.Objects;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
// 简单观察者
public class SimpleObserver implements Observer {
	private int value;
	//观察者需要有主题的指针
	private Subject subject;
	
	public SimpleObserver(Subject subject) {
		this.subject = subject;
		subject.registerObserver(this);
	}
	
	@Override
	public void update(int value) {
		this.value = value;
		display();
	}
	
	public void display() {
		System.out.println("value: " + value);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SimpleObserver that = (SimpleObserver) o;
		return value == that.value &&
				Objects.equals(subject, that.subject);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value, subject);
	}
}
