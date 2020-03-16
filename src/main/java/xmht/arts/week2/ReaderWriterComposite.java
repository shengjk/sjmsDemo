package xmht.arts.week2;

import java.util.List;

public class ReaderWriterComposite<T extends Reader & Writer> implements Reader, Writer {
	private final List<T> readerWriters;
	
	public ReaderWriterComposite(List<T> readerWriters) {
		this.readerWriters = readerWriters;
	}
	
	@Override
	public void write() {
		for (Writer writer : this.readerWriters) {
			writer.write();
		}
	}
	
	@Override
	public void read() {
		for (Reader reader : this.readerWriters) {
			reader.read();
		}
	}
}