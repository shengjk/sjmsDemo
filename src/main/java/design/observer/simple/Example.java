package design.observer.simple;

/**
 * @author shengjk1
 * @date 2020/11/9
 */
public class Example {
	public static void main(String[] args) {
		SimpleSubject simpleSubject = new SimpleSubject();
		SimpleObserver simpleObserver = new SimpleObserver(simpleSubject);
		simpleSubject.setValue(80);
		simpleSubject.removeObserver(simpleObserver);
//		simpleSubject.setValue(80);
	}
}
