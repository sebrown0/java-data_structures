package ds.q;

public class App {

	public static void main(String[] args) {

		long [] l = {1001,1002,1003};
		LIFOQueue q = new Queue(5,  l);
		//LIFOQueue q = new CircularQueue(5);
		q.view();

		//System.out.println("Is full: " + q.nItems + ", " + q.isFull());

		LIFOQueue q1 = q;
		q1.insert(199);
		q1.insert(299);

		q.view();
		
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		q.remove();
		
		q.view();
		
		//System.out.println("Is empty: " + q.isEmpty());
		System.out.println("Front of queue: " + q.peakFront());

	}

}
