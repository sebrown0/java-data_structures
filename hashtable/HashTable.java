package ds.hashtable;

/*
 * Simple implementation of a Hash Table
 */
public class HashTable {

	String[] hashArray;
	int arraySize;
	int size = 0; // number of used slots

	/*
	 * Constructor. Create new array of size given. If size given is not prime use
	 * next prime number.
	 */
	public HashTable(int arraySize) {
		super();
		if (isPrime(arraySize)) {
			// given number is prime so use it
			this.arraySize = arraySize;
			hashArray = new String[arraySize];
		} else {
			// get the next prime number and create array of that size
			int primeCount = getNextPrime(arraySize);
			System.out.println(arraySize + " is not a prime number. So array size changed to " + primeCount);
			this.arraySize = primeCount;
			hashArray = new String[primeCount];
		}
	}

	// Check to see if number is prime.
	private boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	// Loop until prime number found.
	private int getNextPrime(int num) {
		for (int i = num; true; i++) {
			if (isPrime(i))
				return i;
		}
	}

	// Return preferred index.
	private int hashFunc1(String word) {
		int hashVal = word.hashCode();
		hashVal %= arraySize;

		if (hashVal < 0) {
			hashVal += arraySize;
		}

		return hashVal; // ideal index position
	}

	// Return step size greater than 0.
	private int hashFunc2(String word) {
		int hashVal = word.hashCode();
		hashVal %= arraySize;

		if (hashVal < 0) {
			hashVal += arraySize;
		}

		return 3 - (hashVal % 3); // step size
	}

	// Insert word into table.
	public void insert(String word) {
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);

		while (hashArray[hashVal] != null) {
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = word;
		size++;

		System.out.println("Inserted: " + word + " at: " + hashVal);
	}

	// Find given word in table and return it.
	public String find(String word) {
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);

		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].equals(word)) {
				return hashArray[hashVal];
			}
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		return hashArray[hashVal];
	}

	// Display contents of table. Print stars for null values.
	public void displayTable() {
		System.out.println("Table: ");
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i] != null) {
				System.out.println(hashArray[i]);
			} else {
				System.out.println("*****");
			}
		}
	}
}
