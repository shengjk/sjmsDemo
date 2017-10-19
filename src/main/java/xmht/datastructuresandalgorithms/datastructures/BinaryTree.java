package xmht.datastructuresandalgorithms.datastructures;

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
	
	public void displayNode(){
		System.out.printf("%d,%d",iData,dData);
	}
}

class Tree{
	private Node root;
	
	public Tree() {
		root=null;
	}
	
	public Node find(int key){
		Node current=root;
		
		while (current.iData!=key){
			if (key<current.iData){
				current=current.leftChild;
			}else {
				current=current.rightChild;
			}
			if (current==null){
				return null;
			}
		}
		return current;
	}
	
	public void insert(int id,double dd){
		Node newNode=new Node();
		newNode.iData=id;
		newNode.dData=dd;
		
		if (root==null){
			root=newNode;
		}else {
			Node current=root;
			Node parent;
			
			while (true){
				parent=current;
				if(id<current.iData){
					current=current.leftChild;
					if (current==null){
						parent.leftChild=newNode;
						return;
					}
				}else {
					current=current.rightChild;
					
					if (current==null){
						parent.leftChild=newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key){
		Node current =root;
		Node parent=root;
		boolean isLeftChild=true;
		
		while (current.iData!=key){
			parent=current;
			if (key<current.iData){
				isLeftChild=true;
				current=current.leftChild;
			}else {
				isLeftChild=false;
				current=current.leftChild;
			}
			
			if (current==null){
				return false;
			}
			
		}
		
		if (current.leftChild==null && current.rightChild==null){
			if (current==root){
				root=null;
			}else if (isLeftChild){
				parent.leftChild=null;
			}else {
				parent.rightChild = null;
			}
			
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
			
		}else{
			Node successpr=getSuccessor(current);
			
			if (current==root){
				root=successpr;
			}else if (isLeftChild){
				parent.leftChild=successpr;
			}else {
				parent.rightChild=successpr;
			}
			successpr.leftChild=current.leftChild;
		}
		
		return true;
	}
	
	//获取的右节点作为successor
	private Node getSuccessor(Node delNode){
		Node successorParent=delNode;
		Node successor=delNode;
		Node current=delNode.rightChild;
		
		while (current!=null){
			successorParent=successor;
			successor=current;
			current=current.leftChild;
		}
		
		if (successor!=delNode.rightChild){
			successorParent.leftChild=successor.rightChild;
			successor.rightChild=delNode.rightChild;
		}
		return successor;
	}
	
	//先序遍历
	private void preOrder(Node localRoot){
		if (localRoot!=null){
			System.out.println(localRoot.iData +" ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(Node localRoot){
		if (localRoot!=null){
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData+" ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(Node localRoot){
		if (localRoot!=null){
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.println(localRoot.iData+" ");
		}
	}
	
	
	public void displayTree(){
		Stack globaStack=new Stack();
		globaStack.push(root);
		int nBlanks=32;
		boolean isRowEmpty=false;
		System.out.println("==================================");
		while (isRowEmpty==false){
			Stack localStack=new Stack();
			isRowEmpty=true;
			
			for (int j=0;j<nBlanks;j++){
				System.out.println(" ");
			}
			
			while (globaStack.isEmpty()==false){
				Node temp=(Node)globaStack.pop();
				if (temp!=null){
					System.out.println(temp.iData);
				}
				//......
			}
		}
	}
}
public class BinaryTree {
}
