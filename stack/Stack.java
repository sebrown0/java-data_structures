package ds.stack;

public class Stack {

	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}
	
	public void push(char val) {
		if(!isFull()) {
			top++;
			stackArray[top] = val;
		}
	}
	
	public char pop() {
		char val = ' ';
		
		if(!isEmpty()) {
			int oldTop = top;
			top--;
			val = stackArray[oldTop];
		}
		return val;
	}
	
	public long peak() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (maxSize - 1 == top);
	}
}
