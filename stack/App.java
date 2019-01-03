package ds.stack;

public class App {
	
	public static void main(String[] args) {
	
		System.out.println(revString("Hello"));
	}

	public static String revString(String str) {
		Stack theStack = new Stack(str.length());
		String returnVal = "";
		
		for(int i = 0; i < str.length(); i++) {
			theStack.push(str.charAt(i));
		}
		
		while(!theStack.isEmpty()) {
			returnVal += theStack.pop();
		}
		return returnVal;	
	}
	
}
