package ds.q;

public abstract class LIFOQueue {

	protected int maxSize;
	protected int front;
	protected int rear;
	protected int nItems;
	protected long[] queueArray;

	public LIFOQueue(int size) {
		this.maxSize = size;
		this.queueArray = new long[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public LIFOQueue(int size, long[] values) {
		this.maxSize = size;
		this.queueArray = new long[size];
		rear = -1;
		copyValues(values);
	}
	
	private void copyValues(long [] values) {
		int idx = 0;
		while(idx < values.length && idx <= maxSize) {
			queueArray[idx] = values[idx];
			idx++;
			rear++;
		}
		nItems = idx;
	}
	public abstract void insert(long data);

	public long remove() {
		long temp = queueArray[front];
		front++;
		if (front == maxSize) // reached back of the line
			front = 0;
		nItems--;
		return temp;
	}

	public long peakFront() {
		return queueArray[front];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public void view() {
		int idx = front;
		System.out.print("[");
		for (int i = 0; i < nItems - 1; i++) { 
			System.out.print(queueArray[idx] + ", ");
			idx++;
		}
		System.out.print(queueArray[idx] + "]");
		System.out.println();
	}
}
