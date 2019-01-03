package ds.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree {

	private Node root;
	List<LinkedList<Node>> treeList = new ArrayList<LinkedList<Node>>();

	public void getTree(Node node) {

		if (node != null) {
			getTree(node.rightChild);
			System.out.println(" " + node.key);

			getTree(node.leftChild);
		}
	}

	public void getTree(LinkedList<Node> current) {
		LinkedList<Node> next = new LinkedList<>();

		if (!current.isEmpty()) {
			treeList.add(current);

			for (Node node : current) {
				if (node.leftChild != null) {
					next.add(node.leftChild);
				}

				if (node.rightChild != null) {
					next.add(node.rightChild);
				}
			}
			getTree(next);
		}

	}

	public void displayTree() {
		LinkedList<Node> node = new LinkedList<>();
		node.add(root);
		getTree(node);
		// int level = treeList.size();
		// int rootValue = root.key;
		String rootTab = "";
		String leftTab = "";
		String rightTab = "";

		for (int i = 0; i < treeList.size(); i++)
			rootTab += "-----";

		leftTab = rootTab.substring(0, rootTab.length() / 2);
		rightTab = rootTab + rootTab + leftTab + leftTab;

		for (LinkedList<Node> treeNode : treeList) {
			// System.out.println("Level " + level++);

			System.out.println();
			for (Node n : treeNode) {
				if (n.nodeType == NodeType.LEFT) {
					System.out.print(leftTab + n.key);
				} else if (n.nodeType == NodeType.RIGHT) {
					System.out.print(rightTab + n.key);
				} else {
					System.out.print(rootTab + n.key);
				}
			}
			// if((strTab.length() /2) >=1)
			// strTab = strTab.substring(0, (strTab.length() / 2) - 1);
			leftTab = leftTab.substring(0, leftTab.length() / 2);
			rightTab = rightTab.substring(0, rightTab.length() / 2);
		}

	}

	public void insert(int key, String value) {
		Node newNode = new Node(key, value);

		if (root != null) {
			Node current = root;
			Node parent;

			while (true) {
				parent = current;
				if (key < current.key) {
					current = current.leftChild;
					if (current == null) { // Its parent is the leaf node

						parent.leftChild = newNode;
						parent.leftChild.nodeType = NodeType.LEFT;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) { // Its parent is the leaf node

						parent.rightChild = newNode;
						parent.rightChild.nodeType = NodeType.RIGHT;
						return;
					}
				}
			}
		} else {
			// System.out.println("Inserting ROOT -> " + newNode.key);
			root = newNode;
		}
	}

	public Node findMax() {
		Node current = root;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}

	public Node findMin() {
		Node current = root;
		Node last = null;

		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}

	public boolean remove(int key) {

		Node currentNode = root;
		Node parentNode = root;
		boolean isLeftChild = false;

		// Search for node with key
		while (currentNode.key != key) {
			parentNode = currentNode;

			if (key < currentNode.key) {
				// Looking on the left side of the tree
				currentNode = currentNode.leftChild;
				isLeftChild = true;
			} else {
				// Looking on the right side of the tree
				currentNode = currentNode.rightChild;
				isLeftChild = false;
			}
			if (currentNode == null)
				return false;
		}

		// Found a node to delete
		Node nodeToDelete = currentNode;

		// if node is a leaf
		if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			if (nodeToDelete == root)
				root = null;
			else if (isLeftChild)
				parentNode.leftChild = null;
			else
				parentNode.rightChild = null;

		// if node has one child on the left of the tree
		} else if (nodeToDelete.rightChild == null) { // WHY NOT USE isLeftChild
			if (nodeToDelete == root)
				root = nodeToDelete.leftChild;
			else if (isLeftChild)
				parentNode.leftChild = nodeToDelete.leftChild;
			else
				parentNode.rightChild = nodeToDelete.rightChild;
		}
		// if node has one child on the right of the tree
		else if (nodeToDelete.leftChild == null) { // WHY NOT USE isLeftChild
			if (nodeToDelete == root)
				root = nodeToDelete.rightChild;
			else if (isLeftChild)
				parentNode.leftChild = nodeToDelete.rightChild;
			else
				parentNode.rightChild = nodeToDelete.rightChild;
		}
		// if node has two children
		else {
			Node successor = getSuccessor(nodeToDelete);
			// Found minimum value so connect parent of nodeToDelete to successor
			if (nodeToDelete == root)
				root = successor;
			else if (isLeftChild)
				parentNode.leftChild = successor;
			else
				parentNode.rightChild = successor;

			// Replace nodeToDelete with successor
			successor.leftChild = nodeToDelete.leftChild;

		}
		return true;
	}

	private Node getSuccessor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;

		Node current = nodeToDelete.rightChild; // Go to the right

		while (current != null) { // Then keep going left until node has no child
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		// If successor is not a right child
		if (successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;
		}
		return successor;
	}

}
