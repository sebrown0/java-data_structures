package ds.double_linked_list;

public class DoubleLinkedList {

	Node firstNode;	//First node in list
	Node lastNode;	//Last node in list

	//Add a new node to the front of the list
	public void insertFirst(int value) {
		Node newNode = new Node(value);

		if (!isEmpty(firstNode)) {
			firstNode.previousNode = newNode;
			newNode.nextNode = firstNode;
			firstNode = newNode;
		} else {
			firstNode = newNode;
		}

		if (lastNode == null)
			lastNode = firstNode;
	}

	//Add a new node to the end of the list
	public void insertLast(int value) {
		if (!isEmpty(lastNode)) {
			Node newNode = new Node(value);
			lastNode.nextNode = newNode;
			newNode.previousNode = lastNode;
			lastNode = newNode;
		} else {
			insertFirst(value);
		}
	}

	//Insert new node before node that has the value of match
	public void insertBefore(int value, int match) {
		Node n = firstNode;
		Node newNode = new Node(value);

		System.out.println();
		System.out.println("Insert -> " + value + " Before -> " + match);

		// If there are no nodes insert into first
		if (!isEmpty(n)) {
			// Loop until there's a match or we get to the end
			while ((!isEmpty(n.nextNode)) && (n.value != match)) {
				n = n.nextNode;
			}
			//Do we have a match? If not do nothing
			if(n.value == match) {
				newNode.nextNode = n;
				// First in list?
				if (!isEmpty(n.previousNode)) {
					newNode.previousNode = n.previousNode;
					n.previousNode.nextNode = newNode;
	
				}
				n.previousNode = newNode;
	
				if (isEmpty(newNode.previousNode))
					firstNode = newNode;
			}
		} else {
			insertFirst(value);
		}
		printList();
	}

	//Insert new node after node that has the value of match
	public void insertAfter(int value, int match) {
		Node n = firstNode;
		Node newNode = new Node(value);

		System.out.println();
		System.out.println("Insert -> " + value + " After -> " + match);

		// If there are no nodes insert into first
		if (!isEmpty(n)) {
			// Loop until there's a match. If there's no match value is added to end.
			while ((!isEmpty(n.nextNode)) && (n.value != match)) {
				n = n.nextNode;
			}
			newNode.nextNode = n.nextNode;
			newNode.previousNode = n;
			n.nextNode = newNode;
			n.nextNode.previousNode = newNode;
		} else {
			insertFirst(value);
		}
		printList();
	}

	//Delete node with value of key
	public void deleteKey(int key) {
		Node n = firstNode;
		
		System.out.println();
		System.out.println("Deleting Key -> " + key);
	
		while ((!isEmpty(n.nextNode)) && (n.value != key)) {
			n = n.nextNode;
		}
			
		if(n.value == key) {
			if(n == firstNode){
				firstNode = n.nextNode;
			}else if(n == lastNode) {
				lastNode = n.previousNode;
				lastNode.nextNode = null;
			}else {
				n.nextNode.previousNode = n.previousNode;
				n.previousNode.nextNode = n.nextNode;
			}
		} else {
			System.out.println("No Match");
		}
	}
	
	//Delete first node
	public Node deleteFirst() {
		Node returnVal = null;

		if (!isEmpty(firstNode)) {
			returnVal = firstNode;
			if (!isEmpty(firstNode.nextNode)) {
				firstNode = firstNode.nextNode;
				firstNode.previousNode = null;
			} else {
				firstNode = lastNode = null;
			}
		}
		return returnVal;
	}

	//Delete last node
	public Node deleteLast() {
		Node returnVal = null;

		if (!isEmpty(lastNode)) {
			returnVal = lastNode;
			if (!isEmpty(lastNode.previousNode)) {
				lastNode = lastNode.previousNode;
				lastNode.nextNode = null;
			} else {
				firstNode = lastNode = null;
			}
		}
		return returnVal;
	}

	//Check if node is null
	public boolean isEmpty(Node n) {
		return (n == null);
	}

	//Get the length of the list from specified node
	public int listLen(Node n) {
		int idx = 0;
		while (n != null) {
			idx++;
			n = n.nextNode;
		}
		return idx;
	}

	//Print the list to sysout
	public void printList() {
		Node n = firstNode;
		System.out.println();
		System.out.print("[");
		while (n != null) {
			System.out.print(n.value + ",");
			n = n.nextNode;
		}
		System.out.print("]");
	}
}
