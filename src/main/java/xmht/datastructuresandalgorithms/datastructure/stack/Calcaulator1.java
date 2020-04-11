package xmht.datastructuresandalgorithms.datastructure.stack;

/**
 * @author shengjk1
 * @date 2020/2/13
 */
public class Calcaulator1 {
	public static void main(String[] args) {
		// 中缀表达式
		String expression = "5-1*6+2";
		//创建两个栈 数栈、符号栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		
		//用于遍历
		int index = 0;
		int num1, num2 = 0;
		int oper = 0;
		int res = 0;
		//每次扫描得到的char
		char ch = ' ';
		//用来拼接多位数
		String keepNum = "";
		
		while (true) {
			ch = expression.substring(index, index + 1).charAt(0);
			//判断 ch 是什么，然后做相应的处理
			if (operStack.isOper(ch)) {
				//判断当前的符号栈是否为空
				if (!operStack.isEmpty()) {
					//如果当前的操作符的优先级小于等于栈中符号的优先级，就需要从数栈中 pop  两个数
					//在从符号栈中 pop 出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
					
					if (operStack.priority(ch) == 2) {
						while (true) {
							// 按照 优先级去做
							oper = operStack.pop();
							if (oper != 40) {
								num1 = numStack.pop();
								num2 = numStack.pop();
								res = numStack.cal(num1, num2, oper);
								//运算的结果入数栈
								numStack.push(res);
							} else {
								break;
							}
						}
					} else if (operStack.priority(ch) <= operStack.priority(operStack.peek()) && operStack.peek() != 40 && ch != 40) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//运算的结果入数栈
						numStack.push(res);
						//然后将当前的操作符入符号栈
						operStack.push(ch);
					} else {
						//如果当前的操作符大于栈中的操作符，就直接入符号栈
						operStack.push(ch);
					}
				} else {
					//如果为空，直接入符号栈
					operStack.push(ch);
				}
			} else {
				// 如果是数字则直接入数栈
//				numStack.push(ch - 48);
				//看 index 后一位，如果是数则继续进行扫描，如果不是则入栈
				keepNum += ch;
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else {
					if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";
					}
				}
			}
			//让 index +1，并判断是否扫描到 exoression 最后
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		
		//// 按照 优先级去做，如果优先级一样的话，需要按照正常的计算顺序去做
		if (operStack.isSameOper()) {
			ArrayStack2 numStack1 = new ArrayStack2(10);
			ArrayStack2 operStack1 = new ArrayStack2(10);
			
			while (true) {
				if (operStack.isEmpty()) {
					break;
				}
				operStack1.push(operStack.pop());
			}
			while (true) {
				if (numStack.isEmpty()) {
					break;
				}
				numStack1.push(numStack.pop());
			}
			
			//当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
			while (true) {
				if (operStack1.isEmpty()) {
					break;
				}
				//优先级高的运算符已经计算完毕，现在  stack 反转队列，使其从左往右计算
				num1 = numStack1.pop();
				num2 = numStack1.pop();
				oper = operStack1.pop();
				res = numStack1.cal(num2, num1, oper);
				//运算的结果入数栈
				numStack1.push(res);
			}
			System.out.printf("表达式 %s = %d ", expression, numStack1.pop());
		} else {
			while (true) {
				if (operStack.isEmpty()) {
					break;
				}
				//优先级高的运算符已经计算完毕，现在  stack 反转队列，使其从左往右计算
				num1 = numStack.pop();
				num2 = numStack.pop();
				oper = operStack.pop();
				res = numStack.cal(num1, num2, oper);
				//运算的结果入数栈
				numStack.push(res);
			}
			System.out.printf("表达式 %s = %d ", expression, numStack.pop());
		}
		
	}
}

class ArrayStack2 {
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	
	// 栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//查看当前栈顶的值
	public int peek() {
		return stack[top];
	}
	
	//入栈
	public void push(int element) {
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = element;
	}
	
	//出栈
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}
		int temp = stack[top];
//		stack[top]=null; 防止内存泄露
		top--;
		return temp;
	}
	
	//
	public void list() {
		if (isEmpty()) {
			System.out.println("stack is empty");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
	
	//返回运算符的优先级 假设优先级越高返回的数字越大
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else if (oper == ')') {
			return 2;
		} else if (oper == '(') {
			return -1;
		} else {
			//假设目前表达式只有 + - * /
			return -2;
		}
	}
	
	/**
	 * @param val
	 * @return
	 */
	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/' || val == '(' || val == ')';
	}
	
	
	public boolean isSameOper() {
		
		int tem = stack[0];
		for (int i = 1; i <= top; i++) {
			if (priority(tem) != priority(stack[i])) {
				return false;
			}
		}
		return true && top > 0;
	}
	
	/**
	 * 计算
	 *
	 * @param num1
	 * @param num2
	 * @param oper
	 * @return
	 */
	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				//注意顺序
				res = num2 - num1;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
			default:
				break;
		}
		return res;
	}
	
	
}
