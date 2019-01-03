package ds.heap_implementation;
/*
 * Simple implementation of a max heap
 */

public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize; // number of nodes in array

	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new Node[size];
	}

	// Insert new value into heap
	public boolean insert(int key) {
		if (currentSize == maxSize) { // array is full
			return false;
		}

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize);
		currentSize++;

		return true;
	}

	// Trickle up the heap to make sure the node is in the correct place
	private void trickleUp(int idx) {
		int parentIdx = (idx - 1) / 2;
		Node nodeToInsert = heapArray[idx];

		// loop as long as we haven't reached the root and key of nodeToInsert's parent
		// is less than new node
		while (idx > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
			heapArray[idx] = heapArray[parentIdx]; // move parent down
			idx = parentIdx;
			parentIdx = (parentIdx - 1) / 2; // move up to parent
		}
		heapArray[idx] = nodeToInsert; // insert node into its correct position
	}

	// Remove node and return it.
	public Node remove() {
		if (currentSize <= 0) {
			return null;
		}

		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize]; // Assign last to root and 'remove' last from heap
		trickleDown(0);

		return root;
	}

	// Trickle down the heap after removing a node and move the last value to the top.
	private void trickleDown(int idx) {
		Node topNode = heapArray[idx];

		int leftChild;
		int rightChild;
		int biggestChild;

		while (idx < (currentSize / 2)) { // loop until the bottom of the heap

			leftChild = (2 * idx) + 1;
			rightChild = (2 * idx) + 2;
			// check if we've got to the end of heap and see which is the biggest child
			if ((rightChild < currentSize) && (heapArray[(leftChild)].getKey() < heapArray[(rightChild)].getKey())) {
				biggestChild = rightChild;
			} else {
				biggestChild = leftChild;
			}
			// found the correct position so break from loop
			if (topNode.getKey() >= heapArray[biggestChild].getKey()) {
				break;
			}
			// insert node into correct position
			heapArray[idx] = heapArray[biggestChild];
			idx = biggestChild; // Move down
		}
		heapArray[idx] = topNode;
	}

	// Display all the values in the heap.
	public void displayHeap() {
		int idx = 0;
		int row = 0;
		// while there are nodes display them in a tree like way
		while (idx < currentSize - 1) {
			for (int i = 0; i < (1 << row); i++) {
				System.out.print(heapArray[idx++].getKey() + "  ");
			}
			row++;
			System.out.println("");
		}
		System.out.println("Size of heap = " + currentSize);
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}
}
