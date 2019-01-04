package ds.linked_list;

public class Node <i>{

	i value;
	Node<i> nextNode = null;
		
	public Node(i value) {
		super();
		this.value = value;
	}

	public i getValue() {
		return value;
	}

	public void setValue(i value) {
		this.value = value;
	}

	public Node<i> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<i> nextNode) {
		this.nextNode = nextNode;
	}	
	
}
