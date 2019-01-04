package ds.linked_list;

public class LinkedList {

	private Node<Object> firstNode;
	private Node<Object> lastNode;
		
	public void insertFirst(Object value) {
		Node<Object> n = new Node<Object>(value);
		n.nextNode = firstNode;
		firstNode = n;
		
		if(lastNode == null)
			lastNode = firstNode;
	}

	public void insertLast(Object value) {		
		if(!isEmpty(lastNode)) {
			Node<Object> n = lastNode;
			n.nextNode = new Node<Object>(value);
			lastNode = n.nextNode;
		}else {
			insertFirst(value);
		}
	}
	
	public Object deleteFirst() {
		Object value = null;
		if(!isEmpty(firstNode)) {
			value = firstNode.value;
			firstNode = firstNode.nextNode;
		}
		return value;
	}
	
	public boolean isEmpty(Node<Object> n) {
		return (n == null);
	}
		
	public int listLen(Node<?> n) {
		int idx = 0;
		while (n != null) {
			idx++;
			n = n.nextNode;
		}
		return idx;
	}
	
	public void printList() {
		Node<Object> n = firstNode;
		System.out.println();
		System.out.print("[");
		while(n != null) {
			System.out.print(n.value + ",");
			n = n.nextNode;
		}
		System.out.print("]");
	}

	public Node<Object> getFirstNode() {
		return firstNode;
	}

	public Node<Object> getLastNode() {
		return lastNode;
	}
	
}
