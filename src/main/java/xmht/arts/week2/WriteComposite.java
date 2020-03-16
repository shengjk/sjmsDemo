package xmht.arts.week2;

import java.util.List;

/**
 * @author shengjk1
 * @date 2020/3/11
 */
public class WriteComposite<T extends Writer> implements Writer {
	private final List<T> writes;
	
	public WriteComposite(List<T> writes) {
		this.writes = writes;
	}
	
	@Override
	public void write() {
		for (Writer writer : this.writes) {
			writer.write();
		}
	}
}
