package ds.BST;

public class App {

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();

				
		tree.insert(100, "100");
		tree.insert(90, "90");
		tree.insert(80, "80");
		tree.insert(92, "92");
		tree.insert(85, "85");
		tree.insert(91, "91");
		tree.insert(93, "93");
		tree.insert(70, "70");
		tree.insert(72, "72");
		tree.insert(60, "60");
		
		tree.insert(110, "110");
		tree.insert(105, "105");
		tree.insert(115, "115");
		
		tree.insert(193, "110");
		tree.insert(194, "105");
		tree.insert(195, "115");
		tree.insert(196, "115");
		
		tree.displayTree();
//		
//		System.out.println(tree.findMax().key);
//		System.out.println(tree.findMin().key);
//		System.out.println(tree.remove(10));
//		System.out.println(tree.findMin().key);
	}

}
