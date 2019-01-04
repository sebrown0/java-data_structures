package ds.linked_list;

public class App {

	public static void main(String[] args) {

		LinkedList lList = new LinkedList();
		
		lList.insertFirst("Hello");
		lList.insertLast("number");
		lList.insertLast(1);
		lList.printList();
		lList.deleteFirst();
		lList.printList();
	}
	
}
