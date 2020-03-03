package xmht.javabase.java4;

import java.util.Arrays;

/**
 * @author shengjk1
 * @date 2020/3/3
 */

class Processor {
	public String name() {
		return getClass().getSimpleName();
	}
	
	Object process(Object input) {
		return input;
	}
}

class Upcase extends Processor {
	@Override
	String process(Object input) {
		return ((String) input).toUpperCase();
	}
}

class Downcase extends Processor {
	@Override
	String process(Object input) {
		return ((String) input).toLowerCase();
	}
}

class Splitter extends Processor {
	@Override
	String process(Object input) {
		return Arrays.toString(((String) input).split(" "));
	}
}

public class Apply {
	public static void process(Processor p, Object s) {
		System.out.println("User Processor " + p.name());
		System.out.println(p.process(s));
	}
	
	public static String s = "aadgds gsdgkhlsd  fsfdsf sdfjkjklsd ";
	
	public static void main(String[] args) {
		//策略的设计模式
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
	}
}

