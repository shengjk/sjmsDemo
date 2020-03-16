package xmht.arts.week2;

// try catch resource
public class Resource implements AutoCloseable {
	public Resource() throws Exception {
		System.out.println("Created resource");
	}
	
	public void someAction() throws Exception {
		System.out.println("Performed some action");
	}
	
	@Override
	public void close() {
		System.out.println("Closed resource");
	}
	
}