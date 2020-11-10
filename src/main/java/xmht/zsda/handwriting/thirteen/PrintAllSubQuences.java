package xmht.zsda.handwriting.thirteen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author shengjk1
 * @date 2020/11/7
 */
/*
所有的子序列，顺序不变
 */
public class PrintAllSubQuences {
	public static ArrayList<String> subs(String s) {
		char[] str = s.toCharArray();
		String path = "";
		ArrayList<String> ans = new ArrayList<>();
		process1(str, 0, ans, path);
		return ans;
	}
	
	public static void process1(char[] str, int index, List<String> ans, String path) {
		if (index == str.length) {
			ans.add(path);
			return;
		}
		
		String no = path;
		System.out.println("no = " + no);
		process1(str, index + 1, ans, no);
		String yes = path + str[index];
		System.out.println("yes = " + yes);
		process1(str, index + 1, ans, yes);
		
	}
	
	public static List<String> subsNoRepeat(String s) {
		char[] str = s.toCharArray();
		String path = "";
		HashSet<String> set = new HashSet<>();
		process2(str, 0, set, path);
		List<String> ans = new ArrayList<>();
		for (String cur : set) {
			ans.add(cur);
		}
		return ans;
	}
	
	public static void process2(char[] str, int index, HashSet<String> set, String path) {
		if (index == str.length) {
			set.add(path);
			return;
		}
		String no = path;
		process2(str, index + 1, set, no);
		String yes = path + String.valueOf(str[index]);
		process2(str, index + 1, set, yes);
	}
	
	public static void main(String[] args) {
		String test = "abc";
		List<String> ans1 = subs(test);
		List<String> ans2 = subsNoRepeat(test);
		
		for (String str : ans1) {
			System.out.println(str);
		}
		System.out.println("=================");
		for (String str : ans2) {
			System.out.println(str);
		}
		System.out.println("=================");
		
	}
}
