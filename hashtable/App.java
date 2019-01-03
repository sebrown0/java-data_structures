package ds.hashtable;

public class App {

	public static void main(String[] args) {

		HashTable table = new HashTable(190);
		
		table.insert("Apple");
		table.insert("Hello");
		table.insert("Feeling");
		table.insert("Water");
		table.insert("Africa");
		table.insert("Speed");
		table.insert("Phone");
		table.insert("September");
		table.insert("Michael");
		table.insert("Milk");
		table.insert("Huge");
		table.insert("Dogs");

		System.out.println(table.find("Apple"));
		
		table.displayTable();

	}

}
