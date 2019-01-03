package ds.q;

public class CircularQueue extends LIFOQueue{

	public CircularQueue(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(long data) {
		if (rear == maxSize - 1) {
			rear = -1;
			nItems = 0;
		}
		nItems++;
		rear++;
		queueArray[rear] = data;
	}

}
