package ds.heap_implementation;

public class App {

	public static void main(String[] args) {

		int data[] = { 13, 10, 9};//, 6, 2, 7, 8,99};
		Heap heap = new Heap(data.length);

		for (int i : data) {
			heap.insert(i);
		}

		heap.displayHeap();
		//System.out.println("-------");
		
		Node n = heap.remove();
		System.out.println("Removed:" + n.getKey());
		
		heap.displayHeap();
//		System.out.println("-------");
//		
//		n = heap.remove();
//		System.out.println("Removed:" + n.getKey());
//		
//		System.out.println("-------");
//		heap.displayHeap();
//		n = heap.remove();
//		System.out.println("Removed:" + n.getKey());

	}

}
