package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/19 0019
 */
class StackxX {
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackxX(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}
	
	public void push(char j) {
		stackArray[++top] = j;
	}
	
	public char pop() {
		return stackArray[top--];
	}
	
	public char peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
}

class BracketChecker {
	private String input;
	
	public BracketChecker(String in) {
		input = in;
	}
	public void check(){
		int stackSize=input.length();
		StackxX stackX=new StackxX(stackSize);
		for (int i = 0; i < input.length(); i++) {
			char ch=input.charAt(i);
			switch (ch){
				case '{':
				case '[':
				case '(':
					stackX.push(ch);
				break;
				case '}':
				case ']':
				case ')':
					if(!stackX.isEmpty()){
						char chx=stackX.pop();
						if((chx=='}' && chx!='{')
							|| (chx==']' && chx!='[')
								||(chx=='(' && chx!=')')
								){
							System.out.println("Error: "+ch +"at "+i);
							
						}
					}else {
						System.out.println("Error "+ch+" at "+i);
					}
					default:
						break;
			}
		}
		if(!stackX.isEmpty()){
			System.out.println("Error :missing right delimiter");
		}
	}
}
class BracketApp{
	public static void main(String[] args) {
		String input;
		while(true){
			System.out.println("Enter string containing delimiters:");
			System.out.flush();
		}
	}
}
public class Brackets {
}

