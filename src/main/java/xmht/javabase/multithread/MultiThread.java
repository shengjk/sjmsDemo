package xmht.javabase.multithread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by shengjk1 on 2017/12/21
 */
public class MultiThread {
	public static void main(String[] args) {
		ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
		ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
		for (ThreadInfo threadInfo:threadInfos){
			System.out.println(threadInfo.getThreadId()+" "+threadInfo.getThreadName());
		}
	}
}
