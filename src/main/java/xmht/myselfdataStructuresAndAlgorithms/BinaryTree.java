package xmht.myselfdataStructuresAndAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by shengjk1 on 2017/8/31
 */
/*
O(logN)
二叉搜索树  左子节点要比父节点小
如果关键字随机插入，树会或多或少的平衡一点，如果插入是顺序的，则会很不平衡

 */
class Node{
	public  int iData; //data item(key)
	public double dData; //data item
	public Node leftChild;
	public Node rightChild;
	
	public void displayNode()      // display ourself
	{
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
}

class Tree{
	private Node root;
	
	public Tree() {
		root=null;
	}
	
	
	public boolean isEmpty(){
		if (root==null){
			return true;
		}else {
			return false;
		}
	}
	
	public Node find(int key){
		Node current=root;
		
		if (isEmpty()){
			return null;
		}
		
		//传过来的东西永远在前边
		while (current.iData!=key){
			if (key<current.iData){
				current=current.leftChild;
			}else{
				current=current.rightChild;
			}
			if (current==null){
				return null;
			}
		}
		return current;
	}
	
	/**
	 * current在查找的過程中会变为null，才能发现它查过的上一个节点没有一个对应的子节点。如果不存储parent，就会失去插入新节点的位置
	 * 到最后只有一个root节点
	 * @param id
	 * @param dd
	 */
	public void insert(int id,double dd){
		Node newNode=new Node();
		newNode.iData=id;
		newNode.dData=dd;
		
		if (isEmpty()){
			root=newNode;
		}else {
			Node current=root;
			Node parent=null;
			
			while (true){
				parent=current;
				
				if (id<current.iData){
					current=current.leftChild;
					if (null==current){
						parent.leftChild=newNode;
						return;
					}
				}else {
					current=current.rightChild;
					if (null==current){
						parent.rightChild=newNode;
						return;
					}
				}
			}
		}
	}
	
	
	public Node getMinNode(){
		if (isEmpty()){
			return null;
		}
		Node current,last=null;
		current=root;
		while (current!=null){
			last=current;
			current=current.leftChild;
		}
		return last;
	}
	
	public Node getMaxNode(){
		if (isEmpty()){
			return null;
		}
		Node current,last=null;
		current=root;
		while (current!=null){
			last=current;
			current=current.rightChild;
		}
		return last;
	}
	
	
	/**
	 * 删除节点，常用
	 * 三种情况：
	 * 1.该节点是叶节点
	 * 2.该节点有一个子节点
	 * 3.该节点有两个子节点
	 */
	/**
	 *
	 * @param key
	 * @return
	 */
	public boolean delete(int key){
		
		
		
		Node current=root;
		Node parent=root;
		boolean isLeftChild=true;
		
		while (current.iData!=key){
			parent=current;
			
			if (key<current.iData){
				isLeftChild=true;  //初始值跟赋值永远是区分开的，即使初始值跟要赋旳值一致
				current=current.leftChild;
			}else {
				isLeftChild=false;
				current=current.rightChild;
			}
			
			if (current==null){
				return false;
			}
		}
		
		/*
		要删除叶节点，只需要改变该节点的父节点的对应字段的值，由指向该节点改为null就可以了。
		要删除的节点依然存在，但它已经不是树的一部分了。因为java语言有垃圾自动收集的机制，所以不需要非得把节点本身删掉。
		一旦java意识到程序不再与这个节点有 关联，就会自动把它清理出存储器
		 */
		
		/*
		 *删除没有子节点的
		 */
		if (null==current.rightChild && null==current.leftChild){
			if (current==root){
				root=null;
			}else if (isLeftChild){
				parent.leftChild=null;
			}else {
				parent.rightChild=null;
			}
		/*
		删除有一个子节点的
		 */
		}else if (current.rightChild==null){
			if (current==root){
				root=current.leftChild;
			}else if (isLeftChild){
				parent.leftChild=current.leftChild;
			}else {
				parent.rightChild=current.leftChild;
			}
		}else if (current.leftChild==null){
			if (current==root){
				root=current.rightChild;
			}else if (isLeftChild){
				parent.leftChild=current.rightChild;
			}else {
				parent.rightChild=current.rightChild;
			}
		}
		/*
		删除有两个子节点的
		删除两个节点时，要用它的中序后继来代替该节点
		首先，程序找到初始节点的右子节点，它的关键字值一定比初始的节点大，
		然后转到初始节点的右子节点的左子节点那里(如果有的话)，然后到这个左子节点的左子节点
		依次类推，顺着左子节点的路径一直找下去，这个路径上最后一个左子节点就是初始节点的后继
		
		 */
		else{
			Node sucessor=getSuccessor(current);
			if (current==root){
				root=sucessor;
			}else if (isLeftChild){
				parent.leftChild=sucessor;
			}else {
				parent.rightChild=sucessor;
			}
			sucessor.leftChild=current.rightChild;
		}
		return  true;
	}
	
	
	/*
	找后继节点
	 */
	private Node getSuccessor(Node delNode){
		Node sucessorParent=delNode;
		Node successor=delNode;
		Node current=delNode.rightChild;
		while (current!=null){
			sucessorParent=successor;
			successor=current;
			current=current.leftChild;
		}
		
		if (successor!=delNode.rightChild){
			sucessorParent.leftChild=successor.rightChild;
			successor.rightChild=delNode.rightChild;
		}
		return successor;
	}
	
	/**
	 * 遍历树
	 * 这个过程不如查找、插入、删除节点常用，，其中一个原因是遍历树的速度不是特别得空
	 * 快。
	 * 二叉搜索树最长用的遍历方法是中序遍历
	 */
	public void traverse(int traverseType)
	{
		switch(traverseType)
		{
			case 1: System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
			case 2: System.out.print("\nInorder traversal:  ");
				inOrder(root);
				break;
			case 3: System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println();
	}
	// -------------------------------------------------------------
	/**
	 * 前序遍历
	 * 1.访问节点
	 * 2.调用自身遍历该节点的左子树
	 * 3.调用自身遍历该接单的右子树
	 * @param localRoot
	 */
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	// -------------------------------------------------------------
	/**
	 * 中序遍历
	 * 1.调用自身来遍历左子树
	 * 2.访问这个节点
	 * 3.调用自身来遍历右子树
	 */
	private void  inOrder(Node localRoot){
		if (localRoot!=null){
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData);
			inOrder(localRoot.rightChild);
		}
	}
	// -------------------------------------------------------------
	
	/**
	 *后序遍历
	 * 1.调用自身遍历节点的左子树
	 * 2.调用自身遍历节点的右子树
	 * 3.访问该节点
	 * @param localRoot
	 */
	private void postOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
	// -------------------------------------------------------------
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int j=0; j<nBlanks; j++)
				System.out.print(' ');
			
			while(globalStack.isEmpty()==false)
			{
				Node temp = (Node)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null ||
							temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			}  // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
				"......................................................");
	}  // end displayTree()
// -------------------------------------------------------------
}  // end class Tree
////////////////////////////////////////////////////////////////
class TreeApp
{
	public static void main(String[] args) throws IOException
	{
		int value;
		Tree theTree = new Tree();
		
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);
		theTree.insert(43, 1.7);
		theTree.insert(30, 1.5);
		theTree.insert(33, 1.2);
		theTree.insert(87, 1.7);
		theTree.insert(93, 1.5);
		theTree.insert(97, 1.5);
		
		while(true)
		{
			System.out.print("Enter first letter of show, ");
			System.out.print("insert, find, delete, or traverse: ");
			int choice = getChar();
			switch(choice)
			{
				case 's':
					theTree.displayTree();
					break;
				case 'i':
					System.out.print("Enter value to insert: ");
					value = getInt();
					theTree.insert(value, value + 0.9);
					break;
				case 'f':
					System.out.print("Enter value to find: ");
					value = getInt();
					Node found = theTree.find(value);
					if(found != null)
					{
						System.out.print("Found: ");
						found.displayNode();
						System.out.print("\n");
					}
					else
						System.out.print("Could not find ");
					System.out.print(value + '\n');
					break;
				case 'd':
					System.out.print("Enter value to delete: ");
					value = getInt();
					boolean didDelete = theTree.delete(value);
					if(didDelete)
						System.out.print("Deleted " + value + '\n');
					else
						System.out.print("Could not delete ");
					System.out.print(value + '\n');
					break;
				case 't':
					System.out.print("Enter type 1, 2 or 3: ");
					value = getInt();
					theTree.traverse(value);
					break;
				default:
					System.out.print("Invalid entry\n");
			}  // end switch
		}  // end while
	}  // end main()
	// -------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// -------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
// -------------------------------------------------------------
}  // end class TreeApp
////////////////////////////////////////////////////////////////

public class BinaryTree {
}
