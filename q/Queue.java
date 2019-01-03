package ds.q;

public class Queue extends LIFOQueue{

	public Queue(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}
	
	public Queue(int size, long [] values) {
		super(size, values );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(long data) {
		if (!isFull()) {			
			rear++;
			nItems++;
			queueArray[rear] = data;
		}
	}

}
