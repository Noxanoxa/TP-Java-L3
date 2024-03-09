package Binarytree;

public class Main {
	public static void main(String[] args) {

		NodeTree root = new NodeTree(7, null, null);
		BinaryTree demo = new BinaryTree(root);

		for (int i = 0; i < 5; i++) {
			
			  NodeTree newnd = new NodeTree(i, null, null); demo.addNode(newnd, demo.root);
			 
//		demo.addNode( new NodeTree(i, null, null), demo.root);	
		}
		
		demo.search(7, demo.root);
	}
}
