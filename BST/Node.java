package ds.BST;

public class Node {

	int key;
	String value;
	
	Node leftChild = null;
	Node rightChild = null;
	NodeType nodeType = NodeType.ROOT;	//only used for display purposes

	public Node(int key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	
}
