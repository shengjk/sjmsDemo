package xmht.concurrency.thread.demo4;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author shengjk1
 * @date 2019/9/2
 */
//管道输入/输出流，主要用于线程之间的数据传输，而传输的媒介是内存
public class Piped {
	public static void main(String[] args) throws IOException {
		PipedWriter out = new PipedWriter();
		PipedReader in = new PipedReader();
		//将 writer 的数据写入 reader 里面
		out.connect(in);
		
		//当没有数据过来时，相当于object.wait()
		Thread printThread = new Thread(new Print(in), "PrintThread");
		printThread.start();
		int receive = 0;
		try {
			while ((receive = System.in.read()) != -1) {
				out.write(receive);
				System.out.println("out====== " + receive);
			}
		} finally {
			out.close();
		}
	}
	
	
	static class Print implements Runnable {
		private final PipedReader in;
		
		//PipedReader 传进来
		public Print(PipedReader in) {
			this.in = in;
		}
		
		@Override
		public void run() {
			int receive = 0;
			try {
				while ((receive = in.read()) != -1) {
					System.out.println("receive===== " + receive);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
