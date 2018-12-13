package ds.double_linked_list;

public class App {

	public static void main(String[] args) {

		DoubleLinkedList lList = new DoubleLinkedList();

		int insertBefore = 1000;
		int insertAfter = 90;

		int[] testData = { 21123, 4, 982389, insertAfter, 1094, 4391, 390120, 406173, 182, insertBefore };
		
		for (int i : testData) {
			if (i < 1000) {
				lList.insertFirst(i);
			} else {
				lList.insertLast(i);
			}
		}

		lList.printList();
	}

}
