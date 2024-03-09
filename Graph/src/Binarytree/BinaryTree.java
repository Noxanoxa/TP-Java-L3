package Binarytree;

public class BinaryTree {
	
	NodeTree root;

	public BinaryTree(NodeTree root) {
		super();
		this.root = root;
	}
	
	public void addNode(NodeTree newnd, NodeTree rootExplore) {
		
		if (rootExplore == null) 
			return;
		
		 if(newnd.value > rootExplore.value) {
			 if(rootExplore.right == null)
				 rootExplore.right = newnd;
			 else
			 addNode(newnd, rootExplore.right);
		 }
		 if(newnd.value < rootExplore.value) {
			 if(rootExplore.left == null)
				 rootExplore.left = newnd;
			 else
			 addNode(newnd, rootExplore.left);
		 }
			 
	}
	public void search(int value, NodeTree rootExplore) {
		
		if (rootExplore == null) {
			System.out.println("Value cannot Founded");
			return;
		}
		if(rootExplore.value == value )
			System.out.println("Value is Founded");
		if(value > rootExplore.value) {

				search(value, rootExplore.right);
		}
		if(value < rootExplore.value) {

				search(value, rootExplore.left);
		}
		
	}
	 

	
}
