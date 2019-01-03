package ds.linked_list;

public class LinkedList {

	Node firstNode;
	Node lastNode;
		
	public void insertFirst(int value) {
		Node n = new Node(value);
		n.nextNode = firstNode;
		firstNode = n;
		
		if(lastNode == null)
			lastNode = firstNode;
	}

	public void insertLast(int value) {		
		if(!isEmpty(lastNode)) {
			Node n = lastNode;
			n.nextNode = new Node(value);
			lastNode = n.nextNode;
		}else {
			insertFirst(value);
		}
	}
	
	public int deleteFirst() {
		int value = 0;
		if(!isEmpty(firstNode)) {
			value = firstNode.value;
			firstNode = firstNode.nextNode;
		}
		return value;
	}
	
	public boolean isEmpty(Node n) {
		return (n == null);
	}
		
	public int listLen(Node n) {
		int idx = 0;
		while (n != null) {
			idx++;
			n = n.nextNode;
		}
		return idx;
	}
	
	public void printList() {
		Node n = firstNode;
		System.out.println();
		System.out.print("[");
		while(n != null) {
			System.out.print(n.value + ",");
			n = n.nextNode;
		}
		System.out.print("]");
	}
}
