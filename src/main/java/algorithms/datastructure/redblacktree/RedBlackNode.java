package algorithms.datastructure.redblacktree;

//creating a node for the red-black tree. A node has left and right child, element and color of the node  
class RedBlackNode {
	RedBlackNode leftChild, rightChild;
	int element;
	int color;

	// constructor to set the value of a node having no left and right child
	public RedBlackNode(int element) {
		this(element, null, null);
	}

	// constructor to set value of element, leftChild, rightChild and color
	public RedBlackNode(int element, RedBlackNode leftChild, RedBlackNode rightChild) {
		this.element = element;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		color = 1;
	}
}