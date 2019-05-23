package linkedlist;



public class MyStringLinkedList {
	Node header;
	public MyStringLinkedList(){
		header = new Node(null,null, null);
	}
	public void add(String item){
		Node n = new Node(header.next,header,item);
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;
		
	}
	public String get(int pos){
		if(pos >= size()) return null;
		Node n = header;
		Node next = null;	
		for(int i = 0; i <= pos; ++i){
			next = n.next;
			n = next;
		}
		//next is the node we are seeking
		return (next != null) ? next.value : null;
	}
	
	private Node getNode(int pos){
		if(pos >= size()) return null;
		Node n = header;
		Node next = null;	
		for(int i = 0; i <= pos; ++i){
			next = n.next;
			n = next;
		}
		//next is the node we are seeking
		return next;
	}	
	/** returns the index of the String s, if found; 
	 * -1 otherwise 
	 */
	public int find(String s){
		if(s == null) return -1;
		Node currentNode = header;
		int i = -1;
		while(currentNode.next != null){
			++i;
			currentNode = currentNode.next;
			if(s.equals(currentNode.value)) return i;
		}
		return -1;
	}
	
	
	public void insert(String s, int pos){
		if(pos > size()) return;
		Node n = header;
		Node next = null;
		Node previous = null;
		for(int i = 0; i <= pos; ++i){
			if(i==pos){
				previous = n;
			}
			next = n.next;
			n = next;
		}
		//move next one to the right
		Node moveToRight = next;
		Node previousMoveToRight = previous;
		Node insertNode = new Node(moveToRight,previous,s);
		if(moveToRight != null){
			moveToRight.previous = insertNode;
		}
		previous.next =insertNode;
		
		
	}
	/** remove by specifying object -- removes
	 *  first occurrence of s
	 */
	public boolean remove(String s){
		int pos = find(s);
		if(pos == -1) return false;
		return remove(pos);
		
	}
	/** remove object at specified index */
	public boolean remove(int index){
		Node toBeRemoved = getNode(index);
		if(toBeRemoved == null) return false;
		Node previous = toBeRemoved.previous;
		Node next = toBeRemoved.next;
		previous.next = toBeRemoved.next;
		if(next != null){
			next.previous = toBeRemoved.previous;
		}
		toBeRemoved = null;
		return true;
	}
	
	public int size(){
		int count = 0;
		Node n = header;
		Node next = null;
		do {
			next = n.next;
			if(next != null) {
				++count;
				n = next;
			}
		}
		while(next != null);
		return count;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		Node n = header;
		Node next = null;
	
		do {
			next = n.next;
			if(next != null) {
				sb.append(next.value+", ");
				n = next;
			}
		}
		while(next != null);
		String ret = sb.toString();
		
		ret = ret.substring(0,ret.length()-2);
		return (ret +"]");
				
	}
	/******* sorting methods ********/
	public void sort(){
		int size = size();
		if(size<=1) return;
		
		int temp = 0;
		Node curr = header;
		while(curr.next != null){
			curr = curr.next;
			Node min = minNode(curr);
			swap(min,curr);
		}
	}
	/**
	 * Swaps Nodes s and t by switching their 
	 * next, previous and value references. 
	 * To do this without corrupting data, 
	 * a copy of s is made. However, only a shallow
	 * copy is needed -- we actually want to have
	 * the copy of s contain the same next and previous
	 * nodes as those of s itself.
	 * @param s
	 * @param t
	 */
	void swap(Node s, Node t){
		Node sCopy = s.clone();
		s.next = t.next;
		s.previous = t.previous;
		t.next = sCopy.next;
		t.previous = sCopy.previous;
	}
	//find the Node having min value nested inside theNode
	public Node minNode(Node theNode){
		String minVal = theNode.value;
		Node minNode = theNode;
		Node currentNode = theNode;
		while(currentNode.next != null){
			currentNode = currentNode.next;
			if(currentNode.value.compareTo(minVal)<0) {
				minVal = currentNode.value;
				minNode = currentNode;
			}
		}
		return minNode;
	}

	/********* end sorting methods ********/
	
	/******** binary search methods ********/
	
	//search a sorted array
	//Note: because locating the middle value in
	//the list takes linear time each time it's performed,
	//binary search for linked lists is no more efficient
	//than the usual find method
	boolean binSearch(String val) {
		boolean b = recurse(0,size(), val);
		return b;
	}


	boolean recurse(int a, int b, String val) {
		int mid = (a+b)/2;
		if(get(mid).equals(val)) return true;
		if(a > b) return false;
		if(val.compareTo(get(mid))>0) 
			return recurse(mid+1, b, val);
		return recurse(a,mid-1,val);
	}

	/********* end binary search methods *****/
	
	class Node implements Cloneable {
		String value;
		Node next;
		Node previous;
		Node(Node next, Node previous, String value){
			this.next = next;
			this.previous = previous;
			this.value = value;
		}
		/**
		 * This clone() implementation
		 * gives a shallow copy of a Node. 
		 * Nothing more than a shallow copy is needed
		 * for the swap function (which is the only place
		 * clone() is used).
		 */
		public Node clone(){
			
			try {
				return (Node)super.clone();
			}
			catch(CloneNotSupportedException e){
				System.out.println("Unable to clone Node");
				return null;
			}
		}
	}
	public static void main(String[]args){
		MyStringLinkedList l = new MyStringLinkedList();
		l.add("Bob");
		l.add("Jim");
		System.out.println("Size = "+l.size());
		System.out.println("The list = "+l);
		l.insert("Sally",2);
		l.insert("Billy",0);
		System.out.println("Size = "+l.size());
		System.out.println("The list = "+l);
		l.sort();
		System.out.println("The list = "+l);
		System.out.println("Found Bob "+l.find("Bob"));
		System.out.println("Found Bobby "+l.find("Bobby"));
		l.remove("Sally");
		System.out.println(l);
		l.remove(0);
		System.out.println(l);
		System.out.println("List contains Sally? "+l.binSearch("Sally"));
		System.out.println("List contains Bob? "+l.binSearch("Bob"));
		
		
	}

}