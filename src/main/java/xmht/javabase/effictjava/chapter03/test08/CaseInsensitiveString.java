package xmht.javabase.effictjava.chapter03.test08;

import java.util.Objects;

/**
 * @author shengjk1
 * @date 2019-05-15
 */
public class CaseInsensitiveString {
	private final String s;
	
	public CaseInsensitiveString(String s) {
		if (s==null){
			throw new NullPointerException();
		}
		this.s = s;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof CaseInsensitiveString){
			return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
		}else if (o instanceof String){
			return s.equalsIgnoreCase((String)o);
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(s);
	}
	
	
	public static void main(String[] args) {
		CaseInsensitiveString polish = new CaseInsensitiveString("Polish");
		String s="Polish";
		System.out.println(polish.equals(s));
		System.out.println(s.equals(polish));
	}
}
