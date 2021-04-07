package xmht;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengjk1
 * @date 2020/2/29
 */
public class Test5 {
	public static void main(String[] args) {
		Map<Character, Character> dict = new HashMap<Character, Character>() {
			{
				put('{', '}');
				put('[', ']');
				put('(', ')');
				put('?', '?');
			}
		};

		System.out.println("====");
		System.out.println(dict.get('['));


	}

}
