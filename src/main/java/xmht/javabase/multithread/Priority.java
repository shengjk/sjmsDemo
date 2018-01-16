package xmht.javabase.multithread;

/**
 * Created by shengjk1 on 2017/12/21
 */
public class Priority {
	private static volatile boolean notStart=true;
	private static volatile boolean notEnd=true;
	
	public static void main(String[] args) {
	}
	
	static class job implements Runnable{
		private int priority;
		private long jobCount;
		
		public job(int priority) {
			this.priority = priority;
		}
		
		@Override
		public void run() {
		
		}
	}
}
