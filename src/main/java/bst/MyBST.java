package bst;


import java.util.LinkedList;
import java.util.List;

/**
 This implementation of a BST makes the following assumptions:
 1) Data stored in nodes are of type Integer
 2) No duplicate values are inserted. 
 */
public class MyBST {
	private Node root;
	

	//start with an empty tree
	public MyBST() {
		root = null;
	}
	public boolean find(Integer x) {
		if(x==null) return false;
		return find(x,root);
	}	
	public boolean remove(Integer val) {
		
		Node node = findNode(val,root);
		return removeNode(node);
		
		
	}
	public void insert(Integer x) {
		if (root == null) {
			root = new Node(x, null, null);
		}
		else {
			Node n = root;
			boolean inserted = false;
			while(!inserted){
				if(x.compareTo(n.element)<0) {
					//space found on the left
					if(n.left == null){
						n.left = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.left;
					}
				}
				
				else if(x.compareTo(n.element)>0){ 
					//space found on the right					
					if(n.right==null){
						n.right = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.right;
					}
				}
                else { //duplicate value
                    throw new IllegalArgumentException("Duplicate value passed in!");
                }
				
			}

		}
	}	
	public Integer findMin() {
		return findMin(root);
	}
	

	/**
	 * Prints the values in the nodes of the tree in sorted order.
	 */
	public void printTree() {
		if (root == null)
			System.out.println("Empty tree");
		else
			printTree(root);
	}
	
	public List asList() {
		
		return asList(new LinkedList(), root);
		
		
	}
	
	
	///////// PRIVATE METHODS ///////////////

	private void printTree(Node t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}
	private List asList(List theList, Node t) {
		if(theList == null) return theList;
		if(t == null) return theList;
		if(t != null) {
			asList(theList,t.left);
			theList.add(t.element);
			asList(theList,t.right);
		}
		return theList;
	}
	private boolean removeNode(Node node) {
		if(node == null) return false;
		//in this case, we can just break the link
		//from node to its parent
		if(node.left == null && node.right== null) {
			Node parent = parent(node);
			if(parent != null) {
				if(parent.left == node) parent.left = null;
				if(parent.right == node) parent.right = null;
			}
			node = null;
			return true;
		}
		//in these cases, add a link from parent to 
		//child of node
		if( node.left != null && node.right == null ){
			Node parent = parent(node);
			if(parent.left == node) parent.left = node.left;
			if(parent.right == node) parent.right = node.left;
			node = null;
			return true;
		}
		if( node.left == null && node.right != null ){
			Node parent = parent(node);
			if(parent.left == node) parent.left = node.right;
			if(parent.right == node) parent.right = node.right;
			node = null;
			return true;
		}	
		
		//in this case, find min to the right of node and
		//insert this value into the node; link up parent of this min with right child
		//of this min
		
		
		if(node.left != null && node.right != null) {
			Node min = findMinNode(node.right);
			Node parentOfMin = parent(min);
			node.element = min.element;			
			parentOfMin.right = min.right;
			return true;
		}
		return false;
	}
	private Node parent(Node t) {
		return parent(t,root,null);
	}
	private Node parent(Node t, Node n, Node parent) {
		
		if(n == null) return null;
		Integer val = t.element;
		
		
		if(n.element.equals(val)) return parent;
		if(val.compareTo(n.element)<0) {
			return parent(t,n.left, n);
		}
		else {
			return parent(t,n.right,n);
		}
	}
	private Node findNode(Integer val) {
		return findNode(val,root);
	}
	private Node findNode(Integer val,Node n) {
		if(n == null) return null;
		if(n != null && n.element.equals(val)) return n;
		if(val.compareTo(n.element)<0) {
			return findNode(val,n.left);
		}
		else {
			return findNode(val,n.right);
		}
	}
	private Integer findMin(Node t) {
		Node s = findMinNode(t);
		return s.element;
	}
	
	private Node findMinNode(Node t) {
		if(t==null) return null;
		while(t.left != null) {
			t = t.left;
		}
		return t;
	}
	
	
	

	private boolean find(Integer x, Node n){
		if(n == null) return false;
		if(n != null && n.element.equals(x)) return true;
		return (x.compareTo(n.element) < 0) ?
				find(x,n.left) :
				find(x,n.right);
		
	}


	//auxiliary methods
	//not right yet
	/*
	private Node findNextLargerNode(Integer x) {
		if (root == null) {
			return null;
		}
		else {
			Node n = root;
			Boolean xWasBiggerThanLast = null;
			
			while(true){
				if(x.compareTo(n.element)<0) {
					
					if(n.left == null){
						return n;
					}
					else {
						
						if(lastTurnWasLeft == null || 
								lastTurnWasLeft.equals(Boolean.FALSE)){
							
							return n;
						}
						else {
							n = n.left;
						}
					}
				}
				
				else if(x.compareTo(n.element)>0){ 
					//no node is larger					
					if(n.right==null){
						return null;
					}
					else {
						n = n.right;
						if(lastTurnWasLeft == null){
							lastTurnWasLeft = Boolean.FALSE;
						}
						
					}
				}
				
			}

		}
	}*/		
	
	
	public static void main(String[] args){
		MyBST bst = new MyBST();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(12);
		bst.insert(26);
		bst.insert(13);
		
		bst.remove(26);
		bst.remove(12);
		bst.remove(15);
		
		
		bst.insert(21);
		bst.insert(24);
		bst.insert(22);
		System.out.println(bst.asList());
		//bst.printTree();
		System.out.println();
		bst.remove(26);
		
		bst.printTree();
		/*
		MyBST bst = new MyBST();
		bst.insert(10);
		bst.insert(9);
		bst.insert(8);
		MyBST.Node nine = bst.findNode(8);
		MyBST.Node ten = bst.findNode(10);
		System.out.println(ten == bst.parent(nine));
		*/
		/*
		MyBST bst = new MyBST();
		for(int i = 15; i >= 0; --i){
			bst.insert(new Integer(2*i));
			bst.insert(new Integer(2*i - 5));
		}
		bst.printTree();
		System.out.println("Is 24 in the tree? "+bst.find(new Integer(24)));
		System.out.println("Is 27 in the tree? "+bst.find(new Integer(27)));
		//System.out.println("Next larger Node than -5 is "+bst.findNextLargerNode(-5));
		*/
	}

	class Node {

		// Constructors
		Node(Integer theElement) {
			this(theElement, null, null);
		}

		Node(Integer element, Node left, Node right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return element.toString();
		}
		private Integer element; // The data in the node
		private Node left; // Left child
		private Node right; // Right child
	}
}