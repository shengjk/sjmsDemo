package xmht.DataStructuresAndAlgorithms;

/**
 * Created by shengjk1 on 2017/5/31 0031
 */
class Node{
	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;
	
	public void displayNode(){
		System.out.println("{");
		System.out.println(iData);
		System.out.println(",");
		System.out.println(dData);
		System.out.println("}");
	}
}
class Tree{
	private Node root;
	
	public Tree() {
	}
	
	public Node find(int key){
		Node current=root;
		while (current.iData!=key){
			if(key<current.iData){
				current=current.leftChild;
			}else {
				current=current.rightChild;
			}
			if (current==null){
				return  null;
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
				if (id<current.iData){
					current=current.leftChild;
					if (current==null){
						parent.leftChild=newNode;
						return;
					}
				}else {
					current=current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						return;
					}
				}
			}
		}
	}
	
	public boolean delete(int key){
		Node current=root;
		Node parent=root;
		boolean isLeftChild=true;
		while (current.iData!=key){
			parent=current;
			if(key<){
			
			}
		}
	}
}
